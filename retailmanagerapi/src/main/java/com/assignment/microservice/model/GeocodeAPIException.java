package com.assignment.microservice.model;

public class GeocodeAPIException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int errorCode;
	private String errorMessage;

	public GeocodeAPIException() {
	}

	public GeocodeAPIException(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
