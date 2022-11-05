package com.project.onlinebankingservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {
	
	@Id
	private long accountNumber;
	private String name;
	private String middleName;
	private String lastName;
	private String userName;
	private String password;
	private String securityQuestions;
	private String securityAnswers;
	private String accountTypeID;
	
	@Column(name = "mobileNumber")
	private long mobileNumber;
	public User() {
		super();
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getSecurityQuestions() {
		return securityQuestions;
	}
	public void setSecurityQuestions(String securityQuestions) {
		this.securityQuestions = securityQuestions;
	}
	public String getSecurityAnswers() {
		return securityAnswers;
	}
	public void setSecurityAnswers(String securityAnswers) {
		this.securityAnswers = securityAnswers;
	}
	public String getAccountTypeID() {
		return accountTypeID;
	}
	public void setAccountTypeID(String accountTypeID) {
		this.accountTypeID = accountTypeID;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}
