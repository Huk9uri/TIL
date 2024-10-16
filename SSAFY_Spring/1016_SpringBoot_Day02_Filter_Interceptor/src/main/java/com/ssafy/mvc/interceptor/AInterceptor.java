package com.ssafy.mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//인터셉터는 HandlerInterceptor를 구현한 클래스.
@Component
public class AInterceptor implements HandlerInterceptor {
	//java config로 경로 설정해주기
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("A : PRE");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 정상적으로 수행 되고서 실행, 예외 발생시 미실행
		System.out.println("A : POST");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//VIEW가 전달된 후 무조건 실행, 예외 발생시 EX : 해당 예외객체/ 미발생시 EX : NULL
		System.out.println("A : AFTER");
	}
}
