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
@Table(name = "checkbookdetails")
public class Checkbook {
	@Id
	private int checkbookid;
	private long accountnumber;

	public Checkbook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCheckbookid() {
		return checkbookid;
	}

	public void setCheckbookid(int checkbookid) {
		this.checkbookid = checkbookid;
	}

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

}
