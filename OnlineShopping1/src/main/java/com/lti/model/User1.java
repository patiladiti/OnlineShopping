package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;


public class User1 {
	
	
	private String userName;
	
	private String password;
	public User1() {
		super();
		
	}
	public User1(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User1 [userName=" + userName + ", password=" + password + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
