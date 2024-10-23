package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
	
	@GetMapping("/user/loginForm")
	public String loginForm() {
		return "/user/loginForm";
	}
	
}
