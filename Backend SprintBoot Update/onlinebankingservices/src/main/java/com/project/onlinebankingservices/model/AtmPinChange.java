package com.project.onlinebankingservices.model;

public class AtmPinChange {
	
	private int oldpin;
	private int newpin;
	private int conformpin;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public AtmPinChange() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOldpin() {
		return oldpin;
	}
	public void setOldpin(int oldpin) {
		this.oldpin = oldpin;
	}
	public int getNewpin() {
		return newpin;
	}
	public void setNewpin(int newpin) {
		this.newpin = newpin;
	}
	public int getConformpin() {
		return conformpin;
	}
	public void setConformpin(int conformpin) {
		this.conformpin = conformpin;
	}

	
	
}
