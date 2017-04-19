package com.assignment.microservice.model;

import java.io.Serializable;

public class GeocoderGeometry implements Serializable {
	private static final long serialVersionUID = 1L;

	private LatLng location;
	private GeocoderLocationType locationType;
	private LatLngBounds viewport;
	private LatLngBounds bounds;

	public LatLng getLocation() {
		return location;
	}

	public void setLocation(LatLng location) {
		this.location = location;
	}

	public GeocoderLocationType getLocationType() {
		return locationType;
	}

	public void setLocationType(GeocoderLocationType locationType) {
		this.locationType = locationType;
	}

	public LatLngBounds getViewport() {
		return viewport;
	}

	public void setViewport(LatLngBounds viewport) {
		this.viewport = viewport;
	}

	public LatLngBounds getBounds() {
		return bounds;
	}

	public void setBounds(LatLngBounds bounds) {
		this.bounds = bounds;
	}
}
