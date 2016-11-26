package com.gongchuangsu.helloweb.dao;

import java.util.List;
import com.gongchuangsu.helloweb.model.User;

public interface IUserDao {
	List<User> getAllUsers();
	User getUserById(long id);
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	void deleteUserById(long id);
	boolean userExists(String username);
}
