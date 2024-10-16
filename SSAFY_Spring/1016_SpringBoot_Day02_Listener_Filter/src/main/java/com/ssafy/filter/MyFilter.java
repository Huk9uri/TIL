package com.ssafy.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class MyFilter extends HttpFilter implements Filter {
    
	private FilterConfig fConfig; // 생성됐을때는 null
	//생성 되고서, 바로 init() 실행되므로
	// doFilter 메소드에서 fConfig를 사용할 수 있다.
	
	
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		///////////////////////////////////////서블릿에게 가기 전 코드
		System.out.println("서블릿 전11");
		//필터는 체이닝 할 수 있어서 doFilter를 통해 다음으로 간다.
		// 더이상 갈 수 없으면? 서블릿으로 보낸다. 
		String encoding = fConfig.getInitParameter("encoding");
		
		String currEncoding = request.getCharacterEncoding();
		
		System.out.println("기본 encoding " + currEncoding);
		
		request.setCharacterEncoding(encoding); //인코딩 방식 - UTF-16으로 변경됨
		String afterSetEnco = request.getCharacterEncoding();
		System.out.println("set 후 기본 encoding " + afterSetEnco);
		chain.doFilter(request, response);
		//////////////////////////////////////사용자에게 가기 전 코드
		System.out.println("서블릿 후11");
	}

	//필터 초기화		// 이 설정파일에 init-param을 통해 encoding --> UTF-16으로 되어있음
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}

}
