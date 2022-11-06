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
@Table(name = "atmDetails")
@Entity
public class Atm {
	@Id
	private int id;
	private long accountnumber;
	private int atmpin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Atm() {
		super();
		// TODO Auto-generated constructor stub
	}

}
