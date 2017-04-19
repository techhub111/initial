package com.assignment.microservice.model;

import java.io.Serializable;
import java.util.List;


public class GeocoderResult implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<String> types;
	private String formatted_address;
	private String place_id;
	private List<GeocoderAddressComponent> addressComponents;
	private GeocoderGeometry geometry;
	private boolean partialMatch;

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public List<GeocoderAddressComponent> getAddressComponents() {
		return addressComponents;
	}

	public void setAddressComponents(List<GeocoderAddressComponent> addressComponents) {
		this.addressComponents = addressComponents;
	}

	public GeocoderGeometry getGeometry() {
		return geometry;
	}

	public void setGeometry(GeocoderGeometry geometry) {
		this.geometry = geometry;
	}

	public boolean isPartialMatch() {
		return partialMatch;
	}

	public void setPartialMatch(boolean partialMatch) {
		this.partialMatch = partialMatch;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
}