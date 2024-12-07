package com.introduce_SE.demo.ClinicWeb.dto.request;

public class IntrospectRequest {

	public IntrospectRequest(String token) {
		super();
		this.token = token;
	}
	
	public IntrospectRequest() {
		
	}

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
