package com.fpt.main.payload.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String refreshToken;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private String address;
	private String phonenumber;
	private List<String> roles;
	

	
	public JwtResponse(String token, String refreshToken, Long id, String username, String email, String address, String phonenumber,
			List<String> roles) {
		this.token = token;
		this.refreshToken = refreshToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phonenumber = phonenumber;
		this.roles = roles;
	}
		
	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}
	
	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}
