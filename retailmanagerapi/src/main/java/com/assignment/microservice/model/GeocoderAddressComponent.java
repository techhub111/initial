package com.assignment.microservice.model;

import java.io.Serializable;
import java.util.List;

public class GeocoderAddressComponent implements Serializable {
    private static final long serialVersionUID = 1L;

    private String longName;
    private String shortName;
    private List<String> types;

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
