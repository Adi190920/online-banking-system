package com.project.onlinebankingservices.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "balancedetails")
public class Balance {

	@Id
	private int id;
	private long accountNumber;
	private int accTypeId;
	private int amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccTypeId() {
		return accTypeId;
	}

	public void setAccTypeId(int accTypeId) {
		this.accTypeId = accTypeId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Balancedetails [id=" + id + ", accountNumber=" + accountNumber + ", accTypeId=" + accTypeId
				+ ", amount=" + amount + "]";
	}

}