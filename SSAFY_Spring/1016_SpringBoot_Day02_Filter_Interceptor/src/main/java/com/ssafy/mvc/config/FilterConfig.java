package com.ssafy.mvc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.mvc.filter.MyFilter;

@Configuration // 설정파일 입니다.
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<MyFilter> myfilter() {
		FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
		//어떤 필터를 설정할건지
		registrationBean.setFilter(new MyFilter());
		// "/hello" 라는 요청이 들어오면, 이 필터를 동작시키겠다.
		registrationBean.addUrlPatterns("/hello");
		// 순서 정하기
		registrationBean.setOrder(1);
		return registrationBean;
	}
}
