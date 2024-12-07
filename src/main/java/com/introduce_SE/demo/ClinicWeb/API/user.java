package com.introduce_SE.demo.ClinicWeb.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.introduce_SE.demo.ClinicWeb.dto.request.AuthenticationRequest;
import com.introduce_SE.demo.ClinicWeb.dto.request.IntrospectRequest;
import com.introduce_SE.demo.ClinicWeb.dto.response.AuthenticationResponse;
import com.introduce_SE.demo.ClinicWeb.dto.response.IntrospectResponse;
import com.introduce_SE.demo.ClinicWeb.service.AuthenticationService;

@RestController
public class user {

	@Autowired
	private AuthenticationService authenticationService;
	
	
	@PostMapping("/api/token") 
	public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest request) throws Exception {
		return authenticationService.authenticate(request);
	}
	
	@PostMapping("/api/introspect")
	public IntrospectResponse authenticate(@RequestBody IntrospectRequest request) throws Exception {
		return authenticationService.introspect(request);
	}
}
