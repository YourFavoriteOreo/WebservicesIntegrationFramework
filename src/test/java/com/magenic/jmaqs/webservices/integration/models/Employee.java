package com.magenic.jmaqs.webservices.integration.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

   @JsonProperty("EmployeeID")
   public int employeeID;

   @JsonProperty("EmpFirstName")
   public String empFirstName;

   @JsonProperty("EmpLastName")
  public String empLastName;

   @JsonProperty("EmpAddress")
  public String empAddress;

   @JsonProperty("StateID")
  public int stateID;

   @JsonProperty("CityID")
  public int cityID;

  @JsonProperty("DepartmentID")
  public int departmentID;

  public CityObj CityObj;
  public StateObj StateObj;

  @JsonProperty("DepartmentObj")
  public DepartmentObj DepartmentObj;

    public class CityObj
    {
      public int cityID;
      public String cityName;
    }

    public class StateObj
    {
      public int stateID;
      public String stateName;
      public String stateAbbreviation;
    }

    public class DepartmentObj
    {
      public int departmentID;
      public String departmentName;
    }

    public Employee(int employeeID, String empFirstName, String empLastName, String empAddress,
        int stateID, int cityID, int departmentID, CityObj cityObj, StateObj stateObj, DepartmentObj departmentObj) {
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
