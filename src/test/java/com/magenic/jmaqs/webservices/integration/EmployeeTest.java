package com.magenic.jmaqs.webservices.integration;

import com.magenic.jmaqs.webservices.BaseWebServiceTest;
import com.magenic.jmaqs.webservices.WebServiceDriver;
import com.magenic.jmaqs.webservices.WebServiceUtilities;
import com.magenic.jmaqs.webservices.integration.models.Employee;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

    // Transform the http response into a string content
    HttpEntity responseBody = result.getEntity();
    String content = WebServiceUtilities.getResponseBody(result);

    // Verify we get at least 1 record
    Assert.assertTrue(content.length() > 0);
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
}
