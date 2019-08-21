package com.sapient.password.model;

public class Password {

	private long passId;
	private String oldpwd;
	private String pwd1;// Current password
	private String salt1;
	private String pwd2;
	private String salt2;
	private String pwd3;
	private String salt3;

	
	public Password(String pwd1, String salt1) {
		super();
		this.pwd1 = pwd1;
		this.salt1 = salt1;
	}

	public long getPassId() {
		return passId;
	}

	public void setPassId(long passId) {
		this.passId = passId;
	}

	public String getOldpwd() {
		return oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public String getPwd1() {
		return pwd1;
	}

	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}

	public String getSalt1() {
		return salt1;
	}

	public void setSalt1(String salt1) {
		this.salt1 = salt1;
	}

	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getSalt2() {
		return salt2;
	}

	public void setSalt2(String salt2) {
		this.salt2 = salt2;
	}

	public String getPwd3() {
		return pwd3;
	}

	public void setPwd3(String pwd3) {
		this.pwd3 = pwd3;
	}

	public Password() {
		super();
	}

	public String getSalt3() {
		return salt3;
	}

	public void setSalt3(String salt3) {
		this.salt3 = salt3;
	}

}
