package com.project.onlinebankingservices.model;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Transactions")
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionid;
	private long accountnumber;
	private int acctypeid;
	private String transactiontype;
	private Date transactiondate;
	private int amount;

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public int getAcctypeid() {
		return acctypeid;
	}

	public void setAcctypeid(int acctypeid) {
		this.acctypeid = acctypeid;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public Date getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transactions [transactionid=" + transactionid + ", accountnumber=" + accountnumber + ", acctypeid="
				+ acctypeid + ", transactiontype=" + transactiontype + ", transactiondate=" + transactiondate
				+ ", amount=" + amount + "]";
	}

}
