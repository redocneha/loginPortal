package com.sapient.login.model;

public class Password {

	private long passId;
	private String pwd1;// Current password
	private String salt1;
	private String pwd2;
	private String salt2;
	private String pwd3;
	private String salt3;

	public String getPwd1() {
		return pwd1;
	}

	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}

	public long getPassId() {
		return passId;
	}

	public void setPassId(long passId) {
		this.passId = passId;
	}

	public String getSalt1() {
		return this.salt1;
	}

	public void setSalt1(String salt1) {
		this.salt1 = salt1;
	}

	public String getPwd2() {
		return this.pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getSalt2() {
		return this.salt2;
	}

	public void setSalt2(String salt2) {
		this.salt2 = salt2;
	}

	public String getPwd3() {
		return this.pwd3;
	}

	public void setPwd3(String pwd3) {
		this.pwd3 = pwd3;
	}

	public String getSalt3() {
		return this.salt3;
	}

	public void setSalt3(String salt3) {
		this.salt3 = salt3;
	}

	@Override
	public String toString() {
		return "Password [passId=" + passId + ", pwd1=" + pwd1 + ", salt1=" + salt1 + ", pwd2=" + pwd2 + ", salt2="
				+ salt2 + ", pwd3=" + pwd3 + ", salt3=" + salt3 + "]";
	}
}
