package com.assignment.microservice.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class LatLng implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal lat, lng;

	public LatLng() {
	}

	public LatLng(final BigDecimal lat, final BigDecimal lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public LatLng(final String lat, final String lng) {
		this.lat = new BigDecimal(lat);
		this.lng = new BigDecimal(lng);
	}

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLng() {
		return lng;
	}

	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}

}

   