package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.User;

public interface UserService {
	
	// 1. 회원 추가
	public void regist(User user);
		// 2. 회원 목록
	public List<User> getUserList();
		// 4. 회원 탈퇴
	public void removeUser(int userNum);
		// 5. 로그인
	public User login(String id, String password);
	
	
}
