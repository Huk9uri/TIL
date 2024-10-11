package com.ssafy.ws;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MovieAspect {
	
	@Pointcut("execution(* *(..))")
	public void mypt() { 
		
	}
	
		//코드작성
	@Before ("mypt()")
	public void before() {
		System.out.println("영화관을 갑니다.");
	}
	
	@AfterReturning("mypt()")
	public void afterReturning() {
		System.out.println("영화를 다 보고 나옵니다.");
	}
	
	@AfterThrowing(value = "mypt()", throwing = "th")
	public void afterThrowing(Throwable th) {
		System.out.println("지------잉 핸드폰이 울립니다.");
		if(th instanceof CallException) {
			((CallException) th).handleException();
		}
	}
	@After("mypt()")
	public void after() {
		System.out.println("집에 갑니다.");
	}
}
