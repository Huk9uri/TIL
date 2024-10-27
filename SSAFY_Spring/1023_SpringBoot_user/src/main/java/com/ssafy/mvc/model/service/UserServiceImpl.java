package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dto.User;

@Service
public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void regist(User user) {
		userDao.insertUser(user);
		
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(int userNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User login(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
