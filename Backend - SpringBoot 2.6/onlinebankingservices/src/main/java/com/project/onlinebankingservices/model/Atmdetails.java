package com.project.onlinebankingservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "atmdetails")
@Entity
public class Atmdetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@Override
	public String toString() {
		return "Atmdetails [id=" + id + ", accountnumber=" + accountnumber + ", atmpin=" + atmpin + "]";
	}

	public Atmdetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
