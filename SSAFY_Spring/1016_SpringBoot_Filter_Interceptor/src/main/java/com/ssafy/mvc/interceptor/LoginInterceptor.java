package com.ssafy.mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("로그인 인터셉터 프리핸들 실행");
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			System.out.println("로그인 안함");
			response.sendRedirect("/main");
			return false;
		}
		return true;
	}
}
