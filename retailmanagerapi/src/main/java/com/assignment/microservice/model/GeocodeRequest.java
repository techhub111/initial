package com.assignment.microservice.model;

public class GeocodeRequest {
	private String shopName;
	private String shopNumber;
	private String postalCode;
	
	public GeocodeRequest() {}
	
	public GeocodeRequest(String shopName, String shopNumber, String postalCode) {
		this.shopName = shopName;
		this.shopNumber = shopNumber;
		this.postalCode = postalCode;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopNumber() {
		return shopNumber;
	}
	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
