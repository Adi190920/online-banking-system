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
@Table(name="fundtransfer")
public class FundTransfer {
	
	@Id
	private int transferId;
	private long soureAccNumber;
	private long  destAccNumber;
	private int DestAccTypeId; 
	private double transferAmount;
	public int getTransferId() {
		return transferId;
	}
	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}
	public long getSoureAccNumber() {
		return soureAccNumber;
	}
	public void setSoureAccNumber(long soureAccNumber) {
		this.soureAccNumber = soureAccNumber;
	}
	public long getDestAccNumber() {
		return destAccNumber;
	}
	public void setDestAccNumber(long destAccNumber) {
		this.destAccNumber = destAccNumber;
	}
	public int getDestAccTypeId() {
		return DestAccTypeId;
	}
	public void setDestAccTypeId(int destAccTypeId) {
		DestAccTypeId = destAccTypeId;
	}
	public double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}
	public FundTransfer() {
		super();
		// TODO Auto-generated constructor stub
	} 
}
