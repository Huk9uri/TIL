package com.ssafy.board.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {
	
	//공장을 세워서 쓰기 위함
	private static SqlSessionFactory factory;
	
	static { 
		// 공장을 세워야하는데 그 자원의 위치는
		String resource = "mybatis-config.xml";
		try(InputStream inputStream = Resources.getResourceAsStream(resource)){
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("공장 뚝딱완");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("공장 뚝딱실패");
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
