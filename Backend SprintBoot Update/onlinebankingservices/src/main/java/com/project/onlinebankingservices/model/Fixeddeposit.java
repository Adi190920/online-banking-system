package com.project.onlinebankingservices.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "fixeddeposits")
public class Fixeddeposit {
	
	@Id
	private int fixeddepositid;
	
	private Long accountnumber;
	private String product;
	private String period;
	private double amount;
	@Override
	public String toString() {
		return "Fixeddeposit [fixeddepositid=" + fixeddepositid + ", accountnumber=" + accountnumber + ", product="
				+ product + ", period=" + period + ", amount=" + amount + "]";
	}
	public int getFixeddepositid() {
		return fixeddepositid;
	}
	public void setFixeddepositid(int fixeddepositid) {
		this.fixeddepositid = fixeddepositid;
	}
	public Long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(Long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Fixeddeposit() {
		super();
	}
	
	
}
