package com.hcl.ecommerce.dto;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.lang.NonNull;

public class UserRegistrationDto {
	@NonNull	
	private String userName;
	@NonNull
	private String email;
	@NonNull
	private String phoneNo;
	@NonNull
	private String gender;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	

}
