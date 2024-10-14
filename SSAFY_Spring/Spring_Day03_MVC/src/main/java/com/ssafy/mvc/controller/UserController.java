package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.User;

@Controller
public class UserController {
	
	@GetMapping("/regist")
	public String registform() {
		return "regist";
	}
	
//	@PostMapping("/regist")
//	public String regist(@RequestParam("id") String id, @RequestParam("password") String password) {
//		User user =new User(id, password);
//		
//		System.out.println(user);
//		
//		return "result"; // 에러방지용
//	}
	@PostMapping("/regist")
	public String regist(@ModelAttribute User user) { //DTO를 준비해놓고 모델 속성으로 걸어두면 똑같은 attribute 속성값에 알아서 값을 넣어줌 
		System.out.println(user);
		
		return "result"; // 에러방지용
	}
}
