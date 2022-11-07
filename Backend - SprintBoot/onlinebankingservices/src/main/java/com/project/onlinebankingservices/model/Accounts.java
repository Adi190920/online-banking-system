package com.project.onlinebankingservices.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Entity
@Table(name="Accounts")
public class Accounts {
    @Id
	private int AccountTypeID;
	private String AccountType;
	public int getAccountTypeID() {
		return AccountTypeID;
	}
	public void setAccountTypeID(int accountTypeID) {
		AccountTypeID = accountTypeID;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public Accounts() {
		// TODO Auto-generated constructor stub
	}
	
	
}
