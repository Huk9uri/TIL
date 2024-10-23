package com.ssafy.mvc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//dao 와 mapper를 더해서 객체를 만들어줘
@MapperScan(basePackages = "com.ssafy.mvc.model.dao")
public class DBConfig {
	
}
