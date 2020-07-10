package com.magenic.jmaqs.webservices.integration.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StateObj {

  private long stateID;
  private String stateName;
  private String stateAbbreviation;

  @JsonProperty("StateID")
  public long getStateID() { return stateID; }
  @JsonProperty("StateID")
  public void setStateID(long value) { this.stateID = value; }

  @JsonProperty("StateName")
  public String getStateName() { return stateName; }
  @JsonProperty("StateName")
  public void setStateName(String value) { this.stateName = value; }

  @JsonProperty("StateAbbreviation")
  public String getStateAbbreviation() { return stateAbbreviation; }
  @JsonProperty("StateAbbreviation")
  public void setStateAbbreviation(String value) { this.stateAbbreviation = value; }
}
