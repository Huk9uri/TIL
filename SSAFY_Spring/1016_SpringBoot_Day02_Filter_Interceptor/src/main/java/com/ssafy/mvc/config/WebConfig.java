package com.ssafy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mvc.interceptor.AInterceptor;
import com.ssafy.mvc.interceptor.BInterceptor;
import com.ssafy.mvc.interceptor.CInterceptor;
import com.ssafy.mvc.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	//의존성 주입 (필드주입, 생성자 주입, 설정자 주입)
//	@Autowired
//	private AInterceptor aInterceptor;
//	@Autowired
//	private BInterceptor bInterceptor;
//	@Autowired
//	private CInterceptor cInterceptor;
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 스프링 컨테이너에 있는 AInterceptor를 사용하기 위해 autowired로 의존성 주입
//		registry.addInterceptor(aInterceptor).addPathPatterns("/hello");
//		registry.addInterceptor(bInterceptor).addPathPatterns("/hello");
//		registry.addInterceptor(cInterceptor).addPathPatterns("/hello");
		// hello 라는 요청이 오면, aInterceptor를 동작시키겠다.
		registry.addInterceptor(loginInterceptor).addPathPatterns("/regist");
	}
	
}