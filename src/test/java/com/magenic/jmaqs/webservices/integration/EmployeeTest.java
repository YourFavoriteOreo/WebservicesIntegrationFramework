package com.magenic.jmaqs.webservices.integration;

import com.magenic.jmaqs.webservices.integration.models.CityObj;
import com.magenic.jmaqs.webservices.integration.models.DepartmentObj;
import com.magenic.jmaqs.webservices.integration.models.Employee;
import com.magenic.jmaqs.webservices.integration.models.StateObj;
import com.magenic.jmaqs.webservices.jdk8.BaseWebServiceTest;
import com.magenic.jmaqs.webservices.jdk8.WebServiceUtilities;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.text.StringContent;
import java.util.List;
import java.util.Random;

public class EmployeeTest extends BaseWebServiceTest {



  /*
  Testing the number of results we are getting back are non-zero
   */
  @Test
  public void testGetAllEmployees()throws Exception {
    // Verify the getEmployee API returns a 200
    EmployeeController controller = new EmployeeController();
    SoftAssert softAssert = new SoftAssert();
    CloseableHttpResponse result = controller.getEmployee(this.getWebServiceDriver());
    softAssert.assertEquals(HttpStatus.SC_OK, result.getStatusLine().getStatusCode());

    // Transform the http response into employees we can read
    Employee[] employeesJson = WebServiceUtilities.deserializeJson(result, Employee[].class);

    // Verify we get at least 1 record
    Assert.assertFalse(employeesJson.length < 0);
  }

  /*
  Verify that we are getting the correctly expected employee
   */
  @Test
  public void testGetSpecificEmployee() throws Exception {
    // Verify the employee grabbed exists
    EmployeeController controller = new EmployeeController();
    SoftAssert softAssert = new SoftAssert();
    CloseableHttpResponse result = controller.getSpecificEmployee(this.getWebServiceDriver(), 11800);
    softAssert.assertEquals(HttpStatus.SC_OK, result.getStatusLine().getStatusCode());

    // Break down the grabbed response into an employeeJson
    Employee empJson = WebServiceUtilities.deserializeJson(result, Employee.class);

    // Verify the json was made into an employee object properly
    Assert.assertNotNull(empJson, "Could not deserialize object from json properly");
  }
  /*
  Test adding a new employee and verifying it was added
   */
  @Test
  public void testAddEmployee() throws Exception{
    // Initialize variables
    EmployeeController controller = new EmployeeController();
    SoftAssert softAssert = new SoftAssert();
    Employee newEmp = createNewEmployee();

    // Make the employee into HttpContent to pass to endpoint
    HttpEntity content = (HttpEntity) newEmp;
    CloseableHttpResponse result = controller.addEmployee(this.getWebServiceDriver(), content);

    // Assert the employee was added
    softAssert.assertEquals(HttpStatus.SC_OK, result.getStatusLine().getStatusCode());
  }

  /*
  Test updating an existing employee's information and verify the changes are saved
   */
  @Test
  public void testUpdateEmployeeInfo() throws Exception{
    // Grab an employee that already exists
    EmployeeController controller = new EmployeeController();
    SoftAssert softAssert = new SoftAssert();
    CloseableHttpResponse result = controller.getSpecificEmployee(this.getWebServiceDriver(), 654321);
    softAssert.assertEquals(HttpStatus.SC_OK, result.getStatusLine().getStatusCode());

    // Update the grabbed employee
    Employee empJson = WebServiceUtilities.deserializeJson(result, Employee.class);
    String newLastName = "UpdateLastName";
    empJson.empLastName = newLastName;

    // Make the employee into HttpContent to pass to endpoint
    HttpEntity content = (HttpEntity) empJson;
    CloseableHttpResponse updateResult = controller.updateSpecificEmployee(this.getWebServiceDriver(), content, 654321);

    // Verify the update was successful
    softAssert.assertEquals(HttpStatus.SC_OK, updateResult.getStatusLine().getStatusCode());

    // Get the newly updated employee info and verify it's a match
    CloseableHttpResponse verify = controller.getSpecificEmployee(this.getWebServiceDriver(), 654321);
    Employee updateJson = WebServiceUtilities.deserializeJson(verify, Employee.class);
    softAssert.assertEquals(updateJson.empLastName, newLastName);
  }

  /*
  Test that a user was removed from the employee database
   */
  @Test
  public void testRemoveEmployee() throws Exception{
    // Attempt to remove the employee
    EmployeeController controller = new EmployeeController();
    SoftAssert softAssert = new SoftAssert();
    CloseableHttpResponse result = controller.removeEmployee(this.getWebServiceDriver(), 654321);

    // Check the removal was successful
    softAssert.assertEquals(HttpStatus.SC_OK, result.getStatusLine().getStatusCode());

    // Verify the employee is no longer in the database
    CloseableHttpResponse verify = controller.getSpecificEmployee(this.getWebServiceDriver(), 654321);
    softAssert.assertEquals(HttpStatus.SC_NOT_FOUND, verify.getStatusLine().getStatusCode());
  }

  /*
    Method to create a new employee
 */
  public Employee createNewEmployee() throws Exception{
    // create new employee object
    Random randInt = new Random();
    Employee newEmp = new Employee();

    StateObj stateObj = new StateObj();
    stateObj.setStateID(1);
    stateObj.setStateName("Minnesota");
    stateObj.setStateAbbreviation("MN");

    CityObj cityObj = new CityObj();
    cityObj.setCityName("Rox Town");
    cityObj.setCityID(12);

    DepartmentObj depObj = new DepartmentObj();
    depObj.setDepartmentID(7);
    depObj.setDepartmentName("Quality Engineer");

    newEmp.employeeID =  654321;
    newEmp.empFirstName = "Spider";
    newEmp.empLastName = "Man";
    newEmp.empAddress = "123 Magenic Rox Ln";
    newEmp.StateObj = stateObj;
    newEmp.CityObj = cityObj;
    newEmp.DepartmentObj = depObj;
    newEmp.stateID = stateObj.getStateID();
    newEmp.cityID = cityObj.getCityID();
    newEmp.departmentID= depObj.getDepartmentID();

    return newEmp;
  }
}
