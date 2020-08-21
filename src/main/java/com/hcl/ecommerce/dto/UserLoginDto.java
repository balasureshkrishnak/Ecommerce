package com.hcl.ecommerce.dto;

import com.sun.istack.NotNull;

public class UserLoginDto {
	@NotNull
	private String email;
	@NotNull
	private String password;

	public UserLoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLoginDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
