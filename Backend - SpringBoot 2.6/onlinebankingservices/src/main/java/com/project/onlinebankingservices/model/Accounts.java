package com.project.onlinebankingservices.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Entity
@Table(name="Accounts")
public class Accounts {
    @Id
	private int acctypeid;
	private String acctype;
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAcctypeid() {
		return acctypeid;
	}
	public void setAcctypeid(int acctypeid) {
		this.acctypeid = acctypeid;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}


	
}
