package com.project.onlinebankingservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "atmdetails")
@Entity
public class Atm {

	@Id
	private int atmid;

	private long accountnumber;
	private int atmpin;
	public Atm() {
		super();
	}
	public int getAtmid() {
		return atmid;
	}
	public void setAtmid(int atmid) {
		this.atmid = atmid;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public int getAtmpin() {
		return atmpin;
	}
	public void setAtmpin(int atmpin) {
		this.atmpin = atmpin;
	}
	@Override
	public String toString() {
		return "Atm [atmid=" + atmid + ", accountnumber=" + accountnumber + ", atmpin=" + atmpin + "]";
	}

	
}
