package com.assignment.microservice.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shop {
	@Id
	private String shopName;
	private String shopNumber;
	private String postalCode;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private String formatted_address;
	private String place_id;
	
	public Shop(){}

	public Shop(String shopName, String shopNumber, String postalCode, BigDecimal latitude, BigDecimal longitude,
			String formatted_address, String place_id) {
		super();
		this.shopName = shopName;
		this.shopNumber = shopNumber;
		this.postalCode = postalCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.formatted_address = formatted_address;
		this.place_id = place_id;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
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
