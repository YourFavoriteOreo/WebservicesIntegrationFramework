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
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
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
    EmployeeController controller = new EmployeeController();
    SoftAssert softAssert = new SoftAssert();
    CloseableHttpResponse result = controller.getSpecificEmployee(this.getWebServiceDriver());
    softAssert.assertEquals(HttpStatus.SC_OK, result.getStatusLine().getStatusCode());

    Employee empJson = WebServiceUtilities.deserializeJson(result, Employee.class);

    Assert.assertNotNull(empJson, "Could not deserialize object from json properly");
  }
  /*
  Test adding a new employee and verifying it was added
   */
  @Test
  public void testAddEmployee() throws Exception{
    EmployeeController controller = new EmployeeController();
    SoftAssert softAssert = new SoftAssert();
    Employee newEmp = createNewEmployee();

    HttpEntity content = WebServiceUtilities.serializeJson(newEmp);
    CloseableHttpResponse result = controller.addEmployee(this.getWebServiceDriver(), newEmp);
    softAssert.assertEquals(HttpStatus.SC_OK, result.getStatusLine().getStatusCode());
  }

  /*
  Test updating an existing employee's information and verify the changes are saved
   */
  @Test
  public void testUpdateEmployeeInfo() throws Exception{

  }

  /*
  Test that a user was removed from the employee database
   */
  @Test
  public void testRemoveEmployee() throws Exception{

  }

  public Employee createNewEmployee() throws Exception{
    // create new employee object
    Random randInt = new Random();
    Employee newEmp = new Employee();

    newEmp.employeeID =  randInt.nextInt(99999);
    newEmp.empFirstName = "Spider";
    newEmp.empLastName = "Man";
    newEmp.empAddress = "123 Magenic Rox Ln";
    newEmp.StateObj.setStateID(1);
    newEmp.StateObj.setStateName("Minnesota");
    newEmp.StateObj.setStateAbbreviation("MN");
    newEmp.CityObj.setCityName("Rox Town");
    newEmp.CityObj.setCityID(12);
    newEmp.DepartmentObj.setDepartmentID(7);
    newEmp.DepartmentObj.setDepartmentName("Quality Engineer");
    newEmp.stateID = newEmp.StateObj.getStateID();
    newEmp.cityID = newEmp.CityObj.getCityID();
    newEmp.departmentID= newEmp.DepartmentObj.getDepartmentID();

    return newEmp;
  }
}
