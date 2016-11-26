package com.gongchuangsu.helloweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongchuangsu.helloweb.dao.IUserDao;
import com.gongchuangsu.helloweb.model.User;

@Service
public class UserService implements IUserService{
	@Autowired
	private IUserDao userDao;
	
	@Override
	public User getUserById(long id) {
		User user = userDao.getUserById(id);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}
}
