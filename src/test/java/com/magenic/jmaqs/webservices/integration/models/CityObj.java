package com.magenic.jmaqs.webservices.integration.models;

import java.util.*;
import com.fasterxml.jackson.annotation.*;
public class CityObj {

    private long cityID;
    private String cityName;

    @JsonProperty("CityID")
    public long getCityID() { return cityID; }

    @JsonProperty("CityID")
    public void setCityID(long value) { this.cityID = value; }

    @JsonProperty("CityName")
    public String getCityName() { return cityName; }
    @JsonProperty("CityName")
    public void setCityName(String value) { this.cityName = value; }

    public CityObj() { }
}

