package com.project.onlinebankingservices.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class Users {
	
	@Id
	private long AccountNumber;
	private String Name;
	private String MiddleName;
	private String LastName;
	private String UserName;
	private String Password;
	private String SecurityQuestions;
	private String SecurityAnswers;
	private String AccountTypeID;
	private long MobileNumber;
	
}
