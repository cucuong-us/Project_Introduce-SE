package com.introduce_SE.demo.ClinicWeb.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.introduce_SE.demo.ClinicWeb.service.PatientService;

@Controller(value = "HomeControllerOfUser")
public class home {
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/")
	public String welcome() {
		return "home";
	}
	
	
	
	
}