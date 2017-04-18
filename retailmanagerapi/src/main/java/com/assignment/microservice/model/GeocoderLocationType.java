package com.assignment.microservice.model;

public enum GeocoderLocationType {
    APPROXIMATE,
    GEOMETRIC_CENTER,
    RANGE_INTERPOLATED,
    ROOFTOP;

    public String value() {
        return name();
    }

    public static GeocoderLocationType fromValue(String v) {
        return valueOf(v);
    }
}
