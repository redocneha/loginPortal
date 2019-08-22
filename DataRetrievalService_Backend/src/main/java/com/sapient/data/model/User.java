package com.sapient.data.model;

public class User {

	private Long userID;
//	@Column(name = "emailid", length = 30, unique = true)
	private String emailID;
	private Password password;
	private Boolean emailConfirmationFlag;

	public User() {
		super();
	}

	public User(Long userID, Password password) {
		super();
		this.userID = userID;
		this.password = password;
	}

	public User(String emailID, Password password) {
		super();
		this.emailID = emailID;
		this.password = password;
	}

	public User(Long userID, String emailID, Password password) {
		super();
		this.userID = userID;
		this.emailID = emailID;
		this.password = password;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public Boolean getEmailConfirmationFlag() {
		return emailConfirmationFlag;
	}

	public void setEmailConfirmationFlag(Boolean emailConfirmationFlag) {
		this.emailConfirmationFlag = emailConfirmationFlag;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", emailID=" + emailID + ", password=" + password + ", emailConfirmationFlag="
				+ emailConfirmationFlag + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailID == null) ? 0 : emailID.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (emailID == null) {
			if (other.emailID != null)
				return false;
		} else if (!emailID.equals(other.emailID))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}

}
