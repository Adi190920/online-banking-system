package com.project.onlinebankingservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "balancedetails")
public class Balance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int balanceid;
	
	private long accountnumber;
	private double balance;
	public Balance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBalanceid() {
		return balanceid;
	}
	public void setBalanceid(int balanceid) {
		this.balanceid = balanceid;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Balance [balanceid=" + balanceid + ", accountnumber=" + accountnumber + ", balance=" + balance + "]";
	}
	
	

	
}
