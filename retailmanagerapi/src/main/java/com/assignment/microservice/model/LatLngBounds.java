package com.assignment.microservice.model;

import java.io.Serializable;

public class LatLngBounds implements Serializable {
    private static final long serialVersionUID = 1L;

    private LatLng southwest, northeast;

    public LatLngBounds() {
    }

    public LatLngBounds(final LatLng southwest, final LatLng northeast) {
        this.southwest = southwest;
        this.northeast = northeast;
    }

    public LatLng getSouthwest() {
        return southwest;
    }

    public void setSouthwest(LatLng southwest) {
        this.southwest = southwest;
    }

    public LatLng getNortheast() {
        return northeast;
    }

    public void setNortheast(LatLng northeast) {
        this.northeast = northeast;
    }
}