package com.sapient.login.model;

public class User {
	
	private long userID;

	private String emailID;

	private String hashedpwd;
	
	private String salt;

	public long getUserID() {
		return userID;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", emailID=" + emailID + ", hashedpwd=" + hashedpwd + ", salt=" + salt + "]";
	}

	public String getEmailID() {
		return emailID;
	}

	public String gethashedpwd() {
		return hashedpwd;
	}

	public String getSalt() {
		return salt;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public void sethashedPwd(String hashedpwd) {
		this.hashedpwd = hashedpwd;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public User(long userID, String emailID, String hashedpwd) {
		super();
		this.userID = userID;
		this.emailID = emailID;
		this.hashedpwd = hashedpwd;
	}

	public User() {
		super();
	}

	public User(String emailID, String hashedpwd, String salt) {
		super();
		this.emailID = emailID;
		this.hashedpwd = hashedpwd;
		this.salt = salt;
	}

	public User(long userID, String emailID, String hashedpwd, String salt) {
		super();
		this.userID = userID;
		this.emailID = emailID;
		this.hashedpwd = hashedpwd;
		this.salt = salt;
	}



}
