package com.introduce_SE.demo.ClinicWeb.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "HomeControllerOfUser")
public class home {
	
	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/registration")
	public String registrationPage() {
		return "registration";
	}
	
	@RequestMapping("/")
	public String welcome() {
		return "home";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}