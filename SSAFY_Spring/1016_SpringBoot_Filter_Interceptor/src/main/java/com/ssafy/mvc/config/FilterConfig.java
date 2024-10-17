package com.ssafy.mvc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.mvc.filter.HukFilter;

@Configuration
public class FilterConfig {
	@Bean
	public FilterRegistrationBean<HukFilter> hukFilter() {
		FilterRegistrationBean<HukFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new HukFilter());
		registrationBean.addUrlPatterns("/main");
		registrationBean.setOrder(1);
		return registrationBean;

	}
}
