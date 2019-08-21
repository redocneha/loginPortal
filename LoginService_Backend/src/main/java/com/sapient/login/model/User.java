package com.sapient.login.model;


public class User {
	private long userID;

	private String emailID;

	Password passwordHistory;

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public Password getPasswordHistory() {
		return passwordHistory;
	}

	public void setPasswordHistory(Password passwordHistory) {
		this.passwordHistory = passwordHistory;
	}

	public User() {
		super();
	}

	public User(long userID, String emailID, Password passwordHistory) {
		super();
		this.userID = userID;
		this.emailID = emailID;
		this.passwordHistory = passwordHistory;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", emailID=" + emailID + ", passwordHistory=" + passwordHistory + "]";
	}
}
