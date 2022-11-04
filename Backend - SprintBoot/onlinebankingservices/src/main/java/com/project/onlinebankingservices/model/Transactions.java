package com.project.onlinebankingservices.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Transactions")
public class Transactions {
	
	@Id
	private int TransactionID;
	private long AccountNumber;
	private int AccountTypeID; 
	private String TransactionType;
	private Date TransDate;
	private int Amount;

}
