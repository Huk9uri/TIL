package com.ssafy.ws;

public class MovieAspect {

	// 코드작성
	public void before() {
		System.out.println("영화관을 갑니다.");
	}

	public void afterReturning(String name) {
		if (name.equals("0")) {
			return;
		}
		System.out.println(name + "와 함께 영화를 다 보고 나옵니다.");
	}

	public void afterThrowing(Throwable th) {
		if (th instanceof CallException) {
			System.out.println("지지지지이이이이이잉 전화가 와서 핸드폰이 울립니다.");
			((CallException) th).handleException();
		}
		if (th instanceof LonlyException) {
			((LonlyException) th).handleException();
		}
	}

	public void after() {
		System.out.println("집에 갑니다.");
	}
}
