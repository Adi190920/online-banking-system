package com.project.onlinebankingservices.model;

public class ResetPassword {
	private long accountnumber;
	private String username;
	private String securityquestions;
	private String securityanswers;
	public ResetPassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSecurityquestions() {
		return securityquestions;
	}
	public void setSecurityquestions(String securityquestions) {
		this.securityquestions = securityquestions;
	}
	public String getSecurityanswers() {
		return securityanswers;
	}
	public void setSecurityanswers(String securityanswers) {
		this.securityanswers = securityanswers;
	}
	
	
}
