package com.gongchuangsu.helloweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongchuangsu.helloweb.mapper.UserMapper;
import com.gongchuangsu.helloweb.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Transactional
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	public boolean getUserByLogin(String userName, String password) {
		User user = userMapper.getUserByUserName(userName);
		if(user != null && user.getPassword().equals(password)){
			return true;
		}
		return false;
	}

	@Override
	public boolean getUserByUserName(String userName) {
		User user = userMapper.getUserByUserName(userName);
		if(user != null){
			return false;
		}
		return false;
	}

}
