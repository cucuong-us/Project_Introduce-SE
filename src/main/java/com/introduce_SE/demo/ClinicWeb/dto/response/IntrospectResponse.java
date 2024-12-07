package com.introduce_SE.demo.ClinicWeb.dto.response;

public class IntrospectResponse {

	public IntrospectResponse(boolean valid) {
		super();
		this.valid = valid;
	}

	private boolean valid;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	
	
}
