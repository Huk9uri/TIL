package com.ssafy.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.mvc.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private LoginInterceptor loginInterceptor;

//	public WebConfig(LoginInterceptor loginInterceptor) {
//		this.loginInterceptor = loginInterceptor;
//	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("WebConfig - addInterceptors - 로그인 인터셉터");
		registry.addInterceptor(loginInterceptor).addPathPatterns("/user/viewInfo");

	}
}
