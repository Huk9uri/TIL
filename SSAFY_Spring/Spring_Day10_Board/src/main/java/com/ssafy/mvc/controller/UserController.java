package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginform";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		User tmp = userService.login(user.getId(), user.getPassword());
		// 정상 로그인 : tmp - user 정보 / 비정상 tmp - null
		if(tmp == null) {
			return "redirect:login"; // login get매핑 ㄱ
		}
		// 아래는 정상 로그인
		session.setAttribute("loginUser", tmp.getName());
		return "redirect:list";
	}
	
	@GetMapping("/users")
	public String userList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		return "/user/adminPage";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:list";
	}
	
	@GetMapping("/signup")
	public String signupform() {
		return "/user/signupform";
	}
	
	@PostMapping("/signup")
	public String signup(@ModelAttribute User user) {
		System.out.println(user.toString());
		userService.signup(user);
		return "redirect:list";
	}
	
	
}
