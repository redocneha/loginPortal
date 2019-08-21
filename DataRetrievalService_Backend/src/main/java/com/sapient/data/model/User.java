package com.sapient.data.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Register")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userID;

	@Column(name="emailid")
	private String emailID;

	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
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
