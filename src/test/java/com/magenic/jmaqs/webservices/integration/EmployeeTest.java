package com.magenic.jmaqs.webservices.integration;

import com.magenic.jmaqs.webservices.BaseWebServiceTest;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeTest extends BaseWebServiceTest {

  @Test
  public void GetAllEmployees()throws Exception {
    EmployeeController controller = new EmployeeController();
    CloseableHttpResponse result = controller.getEmployee(this.getWebServiceDriver());
    Assert.assertEquals(HttpStatus.SC_OK, result.getStatusLine().getStatusCode());

  }

  @Test
  public void GetSpecificEmployee(){

  }

  @Test
  public void AddEmployee(){

  }

  @Test
  public void UpdateEmployeeInfo(){

  }

  @Test
  public void RemoveEmployee(){

  }
}
