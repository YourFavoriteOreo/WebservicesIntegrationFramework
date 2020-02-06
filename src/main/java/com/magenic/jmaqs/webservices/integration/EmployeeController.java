package com.magenic.jmaqs.webservices.integration;

import com.magenic.jmaqs.webservices.BaseWebServiceTest;
import com.magenic.jmaqs.webservices.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;

import java.net.*;

public class EmployeeController {

  public CloseableHttpResponse getEmployee(WebServiceDriver webServiceDriver) throws Exception{
    CloseableHttpResponse result = webServiceDriver.getContent("/api/EmployeesAPI/GetEmployees",
        ContentType.APPLICATION_JSON, true);

    return result;
  }

  public CloseableHttpResponse getSpecificEmployee(WebServiceDriver webServiceDriver, String iD) throws Exception{
    CloseableHttpResponse result = webServiceDriver.getContent("$/api/EmployeesAPI/GetEmployee/{iD}",
        ContentType.APPLICATION_JSON,true);

    return result;
  }
}
