package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.User;

import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

	@GetMapping("/user/loginForm")
	public String loginForm() {
		return "/user/loginForm";
	}

	@GetMapping("/list")
	public String getList() {
		return "/user/loginForm";
	}

	@GetMapping("/regist")
	public String registForm() {
		return "/user/regist";
	}

}
