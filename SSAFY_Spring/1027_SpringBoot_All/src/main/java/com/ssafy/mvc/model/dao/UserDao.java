package com.ssafy.mvc.model.dao;

import com.ssafy.mvc.model.dto.User;

public interface UserDao {
	//1. 회원가입
	public int insert(User user);
	//2. 회원탈퇴
	public int delete(User user);
	//3. 회원정보수정
	public int update(User user);
}
