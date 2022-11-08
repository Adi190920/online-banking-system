package com.project.onlinebankingservices.model;

public class loginData {
	private String username;
	private String pwd;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "loginData [username=" + username + ", pwd=" + pwd + "]";
	}
	public loginData(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
	}
	
}
