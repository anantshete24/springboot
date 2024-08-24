package com.jwt.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {

	private String jwtToken;
	private String username;
	
	public JwtResponse(String jwtToken, String username) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public JwtResponse() {
		super();
		this.jwtToken = jwtToken;
        this.username = username;

		// TODO Auto-generated constructor stub
	}
	
	
	 private JwtResponse builder(Builder builder) {
	        jwtToken = builder;
	        username = builder;
	    }
	 
}
