package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ssafy.mvc.model.dto.User;

import jakarta.servlet.http.HttpSession;



@Controller
public class UserController {

		@GetMapping("/login")
		public String loginForm() {
			return "user/loginForm";
		}
		
		@PostMapping("/login")
		public String login(@ModelAttribute User user, HttpSession session) {
			if(user.getId().equals("ssafy") && user.getPw().equals("1234")) {
				session.setAttribute("user_id", user.getId());
				session.setAttribute("user_pw", user.getPw());
				return "redirect:/main";
			}
			return "redirect:/login";
			
		}
		
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "main";
		}
		
		@GetMapping("/user/viewInfo")
		public String viewInfo() {
			return "user/viewInfo";
		}
		
		@PostMapping("/regist")
		public String doRegist(@ModelAttribute User user) {
			
			return entity;
		}
		
		
}
