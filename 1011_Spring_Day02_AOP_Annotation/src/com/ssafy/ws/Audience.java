package com.ssafy.ws;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Audience implements Person{

	
	public void movie() {
		System.out.println("영화를 보기 시작합니다.");
		
		if(new Random().nextBoolean()) {
			throw new CallException();
		}
	}

	//코드작성
}
