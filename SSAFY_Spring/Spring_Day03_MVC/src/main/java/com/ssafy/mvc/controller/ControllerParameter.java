package com.ssafy.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControllerParameter {

	@GetMapping("/test1") // test1이라는 요청인데 Get 방식이라면 아래 함수 호출
	public String test1() {
		// prefix + test1 + suffix
		return "test1"; // /WEB-INF/view/test1.jsp
	}

	// test2로 반환하고 싶은데, 데이터도 같이 보내고 싶다.
	// 반환 타입을 mav 로 바꾸면 되지만 싫다면!!
	@GetMapping("/test2-1")
	public String test2_1(Model model) {
		// Model 이라고 하는 바구니를 준비해줬다.
		model.addAttribute("msg", "model - data입니다");
		return "test2"; // /WEB-INF/view/test1.jsp
	}

	@GetMapping("/test2-2") // 얘도 가능
	public String test2_2(Map<String, Object> model) {
		// Model 이라고 하는 바구니를 준비해줬다.
		model.put("msg", "map - data 입니다.");
		return "test2"; // /WEB-INF/view/test1.jsp
	}

	// 파라미터 값을 가지고 오고 싶다.
	// 파라미터에 뭐가 올 수 있을지 알아두면 좋다.
	@GetMapping("/test3")
	public String test3(Model model, HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		model.addAttribute("id", id);
		return "test3";
	}

	@GetMapping("/test3-1") // query 스트링해서 나온 id, password는 알아서 넣어놔. getparameter 이제 안해도 돼
	public String test3_1(Model model, @RequestParam("id") String id,
			@RequestParam(value = "password", defaultValue = "0000") String password) {
		model.addAttribute("id", id);
		model.addAttribute("password", password);
		return "test3";
	}

}
