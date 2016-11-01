package com.gongchuangsu.helloweb.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private long id;              // �û�ID
	
	private String userName;      // �û���
	
	private String password;      // �û�����
	
	private String emailAddress;  // �ʼ���ַ
	
	private String phoneNumber;   // �ֻ���
	
	private short sex;            // �Ա�
	
	@DateTimeFormat(pattern = "xxxx-MM")
	private Date dateOfBirth;     // ��������
	
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
