package com.magenic.jmaqs.webservices.integration.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

   @JsonProperty("EmployeeID")
   public long employeeID;

   @JsonProperty("EmpFirstName")
   public String empFirstName;

   @JsonProperty("EmpLastName")
  public String empLastName;

   @JsonProperty("EmpAddress")
  public String empAddress;

   @JsonProperty("StateID")
  public long stateID;

   @JsonProperty("CityID")
  public long cityID;

  @JsonProperty("DepartmentID")
  public long departmentID;

  @JsonProperty("CityObj")
  public CityObj CityObj;

  @JsonProperty("StateObj")
  public StateObj StateObj;

  @JsonProperty("DepartmentObj")
  public DepartmentObj DepartmentObj;

    public Employee(long employeeID, String empFirstName, String empLastName, String empAddress,
        long stateID, long cityID, long departmentID, CityObj cityObj, StateObj stateObj, DepartmentObj departmentObj) {
      this.employeeID = employeeID;
      this.empFirstName = empFirstName;
      this.empLastName = empLastName;
      this.empAddress = empAddress;
      this.stateID = stateID;
      this.cityID = cityID;
      this.departmentID = departmentID;
      this.CityObj = cityObj;
      this.StateObj = stateObj;
      this.DepartmentObj = departmentObj;
    }

    public Employee () { }
}
