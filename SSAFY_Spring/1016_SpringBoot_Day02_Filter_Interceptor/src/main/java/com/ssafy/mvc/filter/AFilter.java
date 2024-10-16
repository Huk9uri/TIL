package com.ssafy.mvc.filter;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

// 단점 : 경로를 지정할 수 없다. 모든 요청에 대해서 이 필터가 동작한다.
//@Component // 빈으로 등록한다.
//@Order(3) // Order 어노테이션을 통해 순서를 지정할 수 있다.
public class AFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("서블릿 전3");

		chain.doFilter(request, response); // 모든 필터를 거치고, 서블릿으로 요청이 넘어간다.

		System.out.println("서블릿 후3");

	}

}
