package com.project.onlinebankingservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "fundtransfer")
public class FundTransfer {

	@Id @GeneratedValue
	private int transferid;
	private long sourceaccnumber;
	private long destaccnumber;
	private int destacctypeid;
	private double transferamount;

	public int getTransferid() {
		return transferid;
	}

	public void setTransferid(int transferid) {
		this.transferid = transferid;
	}

	public long getSourceaccnumber() {
		return sourceaccnumber;
	}

	public void setSourceaccnumber(long sourceaccnumber) {
		this.sourceaccnumber = sourceaccnumber;
	}

	public long getDestaccnumber() {
		return destaccnumber;
	}

	public void setDestaccnumber(long destaccnumber) {
		this.destaccnumber = destaccnumber;
	}

	public int getDestacctypeid() {
		return destacctypeid;
	}

	public void setDestacctypeid(int destacctypeid) {
		this.destacctypeid = destacctypeid;
	}

	public double getTransferamount() {
		return transferamount;
	}

	public void setTransferamount(double transferamount) {
		this.transferamount = transferamount;
	}

	public FundTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
