package com.introduce_SE.demo.ClinicWeb.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller(value = "HomeControllerOfAdmin")
public class home {

	@RequestMapping("/trang-chu")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public String homePage() {
		return "this is admin home";
	}
}
