package com.introduce_SE.demo.ClinicWeb.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller(value = "HomeControllerOfUser")
public class home {
	
	@RequestMapping("/home")
	@ResponseBody
	public String homePage() {
		return "this is home page";
	}
}
