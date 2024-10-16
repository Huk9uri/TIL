package com.ssafy.mvc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.mvc.filter.MyFilter;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<MyFilter> myfilter() {
		FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new MyFilter());
		registrationBean.addUrlPatterns("/hello"); // hello 요청이 오면 필터 동작
		registrationBean.setOrder(1);// 순서 적용
		return registrationBean;
	}

}
