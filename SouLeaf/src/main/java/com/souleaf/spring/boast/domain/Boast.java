package com.souleaf.spring.boast.domain;

import java.sql.Date;

public class Boast {

	private int boastNo;
	private String boastTitle;
	private String boastContent;
	private int boastHits;
	private Date boastDate;
	private int memberNo;
	
	public Boast() {}

	public Boast(int boastNo, String boastTitle, String boastContent, int boastHits, Date boastDate, int memberNo) {
		super();
		this.boastNo = boastNo;
		this.boastTitle = boastTitle;
		this.boastContent = boastContent;
		this.boastHits = boastHits;
		this.boastDate = boastDate;
		this.memberNo = memberNo;
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

	public String getBoastContent() {
		return boastContent;
	}

	public void setBoastContent(String boastContent) {
		this.boastContent = boastContent;
	}

	public int getBoastHits() {
		return boastHits;
	}

	public void setBoastHits(int boastHits) {
		this.boastHits = boastHits;
	}

	public Date getBoastDate() {
		return boastDate;
	}

	public void setBoastDate(Date boastDate) {
		this.boastDate = boastDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "Boast [boastNo=" + boastNo + ", boastTitle=" + boastTitle + ", boastContent=" + boastContent
				+ ", boastHits=" + boastHits + ", boastDate=" + boastDate + ", memberNo=" + memberNo + "]";
	}
	
}


