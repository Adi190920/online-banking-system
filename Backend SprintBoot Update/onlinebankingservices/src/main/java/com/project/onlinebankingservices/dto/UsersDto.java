package com.project.onlinebankingservices.dto;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UsersDto {

	private long accountnumber;
	private String name;
	private String middlename;
	private String lastname;
	private String username;
	private String password;
	private String securityquestions;
	private String securityanswers;
	private int acctypeid;
	
	private int balanceid; 
//	public int getBalanceid() {
//		return balanceid;
//	}
//
//	public void setBalanceid(int balanceid) {
//		this.balanceid = balanceid;
//	}
//
	private long mobilenumber;

//	public long getAccountnumber() {
//		return accountnumber;
//	}
//
//	public void setAccountnumber(long accountnumber) {
//		this.accountnumber = accountnumber;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
////
////	public UserDto() {
////		super();
////		// TODO Auto-generated constructor stub
////	}
//
//	public String getMiddlename() {
//		return middlename;
//	}

//	@Override
//	public String toString() {
//		return "User [accountnumber=" + accountnumber + ", name=" + name + ", middlename=" + middlename + ", lastname="
//				+ lastname + ", username=" + username + ", password=" + password + ", securityquestions="
//				+ securityquestions + ", securityanswers=" + securityanswers + ", acctypeid=" + acctypeid
//				+ ", mobilenumber=" + mobilenumber + "]";
//	}
//
//	public void setMiddlename(String middlename) {
//		this.middlename = middlename;
//	}
//
//	public String getLastname() {
//		return lastname;
//	}
//
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getSecurityquestions() {
//		return securityquestions;
//	}
//
//	public void setSecurityquestions(String securityquestions) {
//		this.securityquestions = securityquestions;
//	}
//
//	public String getSecurityanswers() {
//		return securityanswers;
//	}
//
//	public void setSecurityanswers(String securityanswers) {
//		this.securityanswers = securityanswers;
//	}
//
//	public int getAcctypeid() {
//		return acctypeid;
//	}
//
//	public void setAcctypeid(int acctypeid) {
//		this.acctypeid = acctypeid;
//	}
//
//	public long getMobilenumber() {
//		return mobilenumber;
//	}
//
//	public void setMobilenumber(long mobilenumber) {
//		this.mobilenumber = mobilenumber;
//	}

}
