package com.magenic.jmaqs.webservices.integration;

import com.magenic.jmaqs.webservices.BaseWebServiceTest;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest extends BaseWebServiceTest {

  @Test
  public void testGetAllEmployees()throws Exception {
    EmployeeController controller = new EmployeeController();
    CloseableHttpResponse result = controller.getEmployee(this.getWebServiceDriver());
    Assert.assertEquals(HttpStatus.SC_OK, result.getStatusLine().getStatusCode());

  }

  @Test
  public void testGetSpecificEmployee(){

  }

  @Test
  public void testAddEmployee(){

  }

  @Test
  public void testUpdateEmployeeInfo(){

  }

  @Test
  public void testRemoveEmployee(){

  }
}
