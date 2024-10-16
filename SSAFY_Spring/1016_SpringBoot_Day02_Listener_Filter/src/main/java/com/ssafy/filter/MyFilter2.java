package com.ssafy.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

//어노테이션 등록과 web.xml 등록을 혼합하여 사용하면
// 필터의 순서가  꼬일 수 있다. 그러므로 통일을 권장함.

@WebFilter	// 이렇게 등록 가능
public class MyFilter2 extends HttpFilter implements Filter {
    
	private FilterConfig fConfig; // 생성됐을때는 null
	//생성 되고서, 바로 init() 실행되므로
	// doFilter 메소드에서 fConfig를 사용할 수 있다.
	
	
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		///////////////////////////////////////서블릿에게 가기 전 코드
		System.out.println("서블릿 전22");
		//필터는 체이닝 할 수 있어서 doFilter를 통해 다음으로 간다.
		// 더이상 갈 수 없으면? 서블릿으로 보낸다. 
		chain.doFilter(request, response);
		//////////////////////////////////////사용자에게 가기 전 코드
		System.out.println("서블릿 후22");
	}

	//필터 초기화		// 이 설정파일에 init-param을 통해 encoding --> UTF-16으로 되어있음
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}

}
