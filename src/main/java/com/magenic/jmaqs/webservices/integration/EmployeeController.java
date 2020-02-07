package com.magenic.jmaqs.webservices.integration;

import com.magenic.jmaqs.webservices.BaseWebServiceTest;
import com.magenic.jmaqs.webservices.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import sun.awt.windows.WEmbeddedFrame;

import javax.swing.text.StringContent;
import java.net.*;

public class EmployeeController {

  public CloseableHttpResponse getEmployee(WebServiceDriver webServiceDriver) throws Exception{
    CloseableHttpResponse result = webServiceDriver.getContent("/api/EmployeesAPI/GetEmployees",
        ContentType.APPLICATION_JSON, true);

    return result;
  }

  public CloseableHttpResponse getSpecificEmployee(WebServiceDriver webServiceDriver, String iD) throws Exception{
    CloseableHttpResponse result = webServiceDriver.getContent(String.format("/api/EmployeesAPI/PutEmployee/{0}", iD),
        ContentType.APPLICATION_JSON,true);

    return result;
  }

  public CloseableHttpResponse updateSpecificEmployee(WebServiceDriver webServiceDriver, HttpEntity content, String iD) throws Exception{
    CloseableHttpResponse result = webServiceDriver.putContent(String.format("/api/EmployeesAPI/PutEmployee/{0}", iD), content,
        ContentType.APPLICATION_JSON, true);

    return result;
  }

  public CloseableHttpResponse addEmployee(WebServiceDriver webServiceDriver, HttpEntity content) throws Exception{
    CloseableHttpResponse result = webServiceDriver.postContent("/api/EmployeesAPI/PostEmployee", content,
        ContentType.APPLICATION_JSON, true);

    return result;
  }

  public CloseableHttpResponse removeEmployee(WebServiceDriver webServiceDriver, String iD) throws Exception{
    CloseableHttpResponse result = webServiceDriver.deleteContent(String.format("/api/EmployeesAPI/DeleteEmployee/{0}", iD),
        ContentType.APPLICATION_JSON, false);

    return result;
  }
}
