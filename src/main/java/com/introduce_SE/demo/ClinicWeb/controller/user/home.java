package com.introduce_SE.demo.ClinicWeb.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "HomeControllerOfUser")
public class home {
	
	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/")
	public String welcome() {
		return "home";
	}
	
	
	
	
}