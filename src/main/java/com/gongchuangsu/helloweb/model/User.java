package com.gongchuangsu.helloweb.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private long id;              // 用户ID
	
	private String userName;      // 用户名
	
	private String password;      // 用户密码
	
	private String emailAddress;  // 邮件地址
	
	private String phoneNumber;   // 手机号
	
	private short sex;            // 性别
	
	@DateTimeFormat(pattern = "xxxx-MM")
	private Date dateOfBirth;     // 出生日期
	
	public void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	}
	
	public void setUserName(String userName){
		this.userName = userName;		
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setPassword(String password){
		this.password = password;		
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;		
	}
	
	public String getEmailAddress(){
		return emailAddress;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;		
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public void setSex(short sex){
		this.sex = sex;		
	}
	
	public short getSex(){
		return sex;
	}
	
	public void setDateOfBirth(Date dateOfBirth){
		this.dateOfBirth = dateOfBirth;		
	}
	
	public Date getDateOfBirth(){
		return dateOfBirth;
	}
}
