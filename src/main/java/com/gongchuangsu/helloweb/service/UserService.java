package com.gongchuangsu.helloweb.service;

import com.gongchuangsu.helloweb.model.User;

public interface UserService {
	void insertUser(User user);
	boolean getUserByLogin(String userName, String password);
	boolean getUserByUserName(String userName);
}
