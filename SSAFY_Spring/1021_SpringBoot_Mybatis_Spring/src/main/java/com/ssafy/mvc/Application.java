package com.ssafy.mvc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @MapperScan 을 여기다 해줘도 되지만
// 설정은 따로 빼놓고 하는게 편하기 때문에
// config 패키지를 만들고 그곳에서 설정한다.
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
