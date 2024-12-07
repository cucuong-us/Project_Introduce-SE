package com.introduce_SE.demo.ClinicWeb.dto.response;

public class AuthenticationResponse {
	
	public AuthenticationResponse(String token, boolean authenticated) {
		super();
		this.token = token;
		this.authenticated = authenticated;
	}
	
	private String token;
	private boolean authenticated;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean isAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	
	
}
