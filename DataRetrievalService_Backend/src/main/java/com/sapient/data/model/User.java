package com.sapient.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logindetails")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userID;

	private String emailID;

	private String hashedpwd;
	
	private String salt;

	public long getUserID() {
		return userID;
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

	public User(long userID, String hashedpwd, String salt) {
		super();
		this.userID = userID;
		this.hashedpwd = hashedpwd;
		this.salt = salt;
	}

}
