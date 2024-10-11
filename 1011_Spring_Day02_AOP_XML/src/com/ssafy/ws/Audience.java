package com.ssafy.ws;

import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class Audience implements Person {

	private String name;

	public String movie() {
		Scanner sc = new Scanner(System.in);
		System.out.println("누구랑 보나요? 혼자 볼거면 0");
		String name = sc.next();
		if (name.equals("0")) {
			throw new LonlyException();
		} else {
			System.out.println(name + "와 함께 영화를 보기 시작합니다.");
			if (new Random().nextBoolean()) {
				throw new CallException();
			}

			return name;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 코드작성
}
