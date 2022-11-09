package com.project.onlinebankingservices.model;

public class ReqquestBody {
	private long accountNumber;

	public ReqquestBody(long accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "RequestBody [accountNumber=" + accountNumber + "]";
	}

	public ReqquestBody() {
		super();
		// TODO Auto-generated constructor stub
	};
}
