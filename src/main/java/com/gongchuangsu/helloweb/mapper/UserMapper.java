package com.gongchuangsu.helloweb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.gongchuangsu.helloweb.model.User;

public interface UserMapper {
	@Insert("INSERT INTO user_info(username, password) VALUES (#{userName}, #{password})")
	public void insertUser(User user);
	
	@Select("SELECT password FROM user_info WHERE username = #{userName}")
	public User getUserByUserName(String userName);
}