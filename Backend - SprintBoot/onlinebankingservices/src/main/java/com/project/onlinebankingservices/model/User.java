package com.project.onlinebankingservices.model;

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
	private long AccountNumber;
	private String Name;
	private String MiddleName;
	private String LastName;
	private String UserName;
	private String Password;
	private String SecurityQuestions;
	private String SecurityAnswers;
	private String AccountTypeID;
	private long MobileNumber;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getSecurityQuestions() {
		return SecurityQuestions;
	}
	public void setSecurityQuestions(String securityQuestions) {
		SecurityQuestions = securityQuestions;
	}
	public String getSecurityAnswers() {
		return SecurityAnswers;
	}
	public void setSecurityAnswers(String securityAnswers) {
		SecurityAnswers = securityAnswers;
	}
	public String getAccountTypeID() {
		return AccountTypeID;
	}
	public void setAccountTypeID(String accountTypeID) {
		AccountTypeID = accountTypeID;
	}
	
	public long getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		MobileNumber = mobileNumber;
	}
	
}
