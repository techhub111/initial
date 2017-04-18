package com.assignment.microservice.model;

import java.io.Serializable;
import java.util.List;

public class GeocodeResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private GeocoderStatus status;
	private List<GeocoderResult> results;

	public GeocodeResponse() {
	}

	public GeocoderStatus getStatus() {
		return status;
	}

	public void setStatus(GeocoderStatus status) {
		this.status = status;
	}

	public List<GeocoderResult> getResults() {
		return results;
	}

	public void setResults(List<GeocoderResult> result) {
		this.results = result;
	}
}