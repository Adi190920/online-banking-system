package com.project.onlinebankingservices.model;

import java.sql.Date;

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
@Table(name="Transactions")
public class Transactions {
	
	@Id
	private int TransactionID;
	private long AccountNumber;
	private int AccountTypeID; 
	private String TransactionType;
	private Date TransDate;
	private int Amount;
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}
	public long getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		AccountNumber = accountNumber;
	}
	public int getAccountTypeID() {
		return AccountTypeID;
	}
	public void setAccountTypeID(int accountTypeID) {
		AccountTypeID = accountTypeID;
	}
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
	public Date getTransDate() {
		return TransDate;
	}
	public void setTransDate(Date transDate) {
		TransDate = transDate;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}

}

