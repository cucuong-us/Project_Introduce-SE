package com.introduce_SE.demo.ClinicWeb.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller(value = "HomeControllerOfUser")
@SessionAttributes("name")
public class home {
	
	@RequestMapping("home")
	public String homePage() {
		return "home";
	}
}
