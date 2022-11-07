package com.project.onlinebankingservices.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Checkbook")
public class Checkbook {
    @Id
    private int CheckbookID;
    private long AccountNumber;
	public Checkbook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCheckbookID() {
		return CheckbookID;
	}
	public void setCheckbookID(int checkbookID) {
		CheckbookID = checkbookID;
	}
	public long getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		AccountNumber = accountNumber;
	}


}
