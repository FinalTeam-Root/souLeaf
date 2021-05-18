package com.souleaf.spring.boast.domain;

import java.sql.Date;

public class Boast {

	private int boastNo;
	private String boastTitle;
	private String boastCount;
	private Date boastDate;
	private Date boastUpdate;
	private int memberNo;
	private int boastPoint;
	
	public Boast() {}

	public Boast(int boastNo, String boastTitle, String boastCount, Date boastDate, Date boastUpdate, int memberNo,
			int boastPoint) {
		super();
		this.boastNo = boastNo;
		this.boastTitle = boastTitle;
		this.boastCount = boastCount;
		this.boastDate = boastDate;
		this.boastUpdate = boastUpdate;
		this.memberNo = memberNo;
		this.boastPoint = boastPoint;
		
		
	}

	public int getBoastNo() {
		return boastNo;
	}

	public void setBoastNo(int boastNo) {
		this.boastNo = boastNo;
	}

	public String getBoastTitle() {
		return boastTitle;
	}

	public void setBoastTitle(String boastTitle) {
		this.boastTitle = boastTitle;
	}

	public String getBoastCount() {
		return boastCount;
	}

	public void setBoastCount(String boastCount) {
		this.boastCount = boastCount;
	}

	public Date getBoastDate() {
		return boastDate;
	}

	public void setBoastDate(Date boastDate) {
		this.boastDate = boastDate;
	}

	public Date getBoastUpdate() {
		return boastUpdate;
	}

	public void setBoastUpdate(Date boastUpdate) {
		this.boastUpdate = boastUpdate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getBoastPoint() {
		return boastPoint;
	}

	public void setBoastPoint(int boastPoint) {
		this.boastPoint = boastPoint;
	}

	@Override
	public String toString() {
		return "Boast [boastNo=" + boastNo + ", boastTitle=" + boastTitle + ", boastCount=" + boastCount
				+ ", boastDate=" + boastDate + ", boastUpdate=" + boastUpdate + ", memberNo=" + memberNo
				+ ", boastPoint=" + boastPoint + "]";
	}
	
	
	
}
	