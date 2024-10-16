package com.ssafy.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.User;
import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {
    @GetMapping("/login")
    public String loginForm() {
        return "/user/loginForm";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session) {
    	if(user.getId().equals("ssafy") && user.getPw().equals("1234")) {
    		session.setAttribute("loginUser", user.getId());
    		return "redirect:hello";
    	}
    	return "redirect:login";
        

    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 로그아웃을 하는 방법 2가지!
        // 1. 세션에서 유저 속성을 지우는 작업
        session.removeAttribute("loginUser");
        
        // 2. 세션 자체를 초기화
        session.invalidate();
        
        return "redirect:/"; // 메인 인덱스 화면으로 
    }
    
    
    
}
