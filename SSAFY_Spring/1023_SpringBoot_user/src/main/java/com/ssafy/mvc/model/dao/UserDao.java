package com.ssafy.mvc.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.mvc.model.dto.User;

public interface UserDao {

	// 1. 회원 추가
	public void insert(User user);
	// 2. 회원 목록
	public List<User> selectAll();
	// 3. 회원 조회
	public User selectOne(int userNum);
	// 4. 회원 탈퇴
	public void deleteUser(int userNum);
}
