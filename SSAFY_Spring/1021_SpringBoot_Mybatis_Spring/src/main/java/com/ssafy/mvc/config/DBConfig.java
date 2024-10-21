package com.ssafy.mvc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// com.ssafy.mvc.model.dao 패키지와 mapper를 이어줌 getmapper와 동일
@MapperScan(basePackages = "com.ssafy.mvc.model.dao")
public class DBConfig {

}
