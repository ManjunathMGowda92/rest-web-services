package org.manjunath.voterservice.model;

import java.io.Serializable;

public class Addresss implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3726057335650758274L;
	private String doorNo;
	private String street;
	private String locality;
	private String post;
	private String taluk;
	private String district;
	private String state;
	private String country;
	private String zipCode;
	
	public Addresss() {}

	public Addresss(String doorNo, String street, String locality, String post, String taluk, String district,
			String state, String country, String zipCode) {
		this.doorNo = doorNo;
		this.street = street;
		this.locality = locality;
		this.post = post;
		this.taluk = taluk;
		this.district = district;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
