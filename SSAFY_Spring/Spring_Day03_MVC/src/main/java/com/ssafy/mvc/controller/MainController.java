package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	
	@RequestMapping("/") // '/' 요청이 오면 index 반환을 해라ㅡ
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/home", method= RequestMethod.GET)
	public ModelAndView homeHandle1() {
		ModelAndView mav = new ModelAndView();
		
		// 데이터를 심어서 보내보자
		mav.addObject("msg", "Welcome to Spring MVC - GET");
		// view 이름을 결정해야함 // 포워딩과 같음
		mav.setViewName("home"); // return "home"; 과 동일
		return mav;
	}
	
	@RequestMapping(value = "/home", method= RequestMethod.POST)
	public ModelAndView homeHandle2() {
		ModelAndView mav = new ModelAndView();
		
		// 데이터를 심어서 보내보자
		mav.addObject("msg", "Welcome to Spring MVC - POST");
		// view 이름을 결정해야함 // 포워딩과 같음
		mav.setViewName("home"); // return "home"; 과 동일
		return mav;
	}
	
	

}
