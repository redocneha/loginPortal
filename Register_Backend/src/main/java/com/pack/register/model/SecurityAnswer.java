package com.pack.register.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="securityAns")
public class SecurityAnswer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long secId;
	private long securityQueID1;
	private long securityQueID2;
	private String securityAnsID1;
	private String securityAnsID2;
	@Override
	public String toString() {
		return "SecurityAnswer [securityQueID1=" + securityQueID1 + ", securityQueID2=" + securityQueID2
				+ ", securityAnsID1=" + securityAnsID1 + ", securityAnsID2=" + securityAnsID2 + "]";
	}
	public long getSecurityQueID1() {
		return  this.securityQueID1;
	}
	public void setSecurityQueID1(long securityQueID1) {
		this.securityQueID1 = securityQueID1;
	}
	public long getSecurityQueID2() {
		return this.securityQueID2;
	}
	public void setSecurityQueID2(long securityQueID2) {
		this.securityQueID2 = securityQueID2;
	}
	public String getSecurityAnsID1() {
		return this.securityAnsID1;
	}
	public void setSecurityAnsID1(String secqueId1) {
		this.securityAnsID1 = secqueId1;
	}
	public String getSecurityAnsID2() {
		return this.securityAnsID2;
	}
	public void setSecurityAnsID2(String securityAnsID2) {
		this.securityAnsID2 = securityAnsID2;
	}
	

}
