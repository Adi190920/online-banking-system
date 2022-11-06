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
@Table(name = "fundtransfer")
public class FundTransfer {

	@Id
	private int transferid;
	private long soureaccnumber;
	private long destaccnumber;
	private int destacctypeid;
	private double transferamount;

	public int getTransferid() {
		return transferid;
	}

	public void setTransferid(int transferid) {
		this.transferid = transferid;
	}

	public long getSoureaccnumber() {
		return soureaccnumber;
	}

	public void setSoureaccnumber(long soureaccnumber) {
		this.soureaccnumber = soureaccnumber;
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
