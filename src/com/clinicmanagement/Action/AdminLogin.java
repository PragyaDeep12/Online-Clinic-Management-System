package com.clinicmanagement.Action;

import com.opensymphony.xwork2.ActionSupport;

public class AdminLogin extends ActionSupport{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	public String viewLogin()
	{
		return "SUCCESS";
	}
	public String login()
	{
		String msg="";
	if(this.username.equals("ADMIN")&&this.password.equals("ADMIN"))
		msg="VALID";
	else
		msg="INVALID";
		return msg;
	}
	public String getPassword() {
		return password;
	}	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
