package com.magenic.jmaqs.webservices.integration.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepartmentObj {
  private long departmentID;
  private String departmentName;

  @JsonProperty("DepartmentID")
  public long getDepartmentID() { return departmentID; }
  @JsonProperty("DepartmentID")
  public void setDepartmentID(long value) { this.departmentID = value; }

  @JsonProperty("DepartmentName")
  public String getDepartmentName() { return departmentName; }
  @JsonProperty("DepartmentName")
  public void setDepartmentName(String value) { this.departmentName = value; }
}
