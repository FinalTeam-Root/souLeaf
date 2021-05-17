package com.souleaf.spring.qna.domain;

import java.sql.Date;
import java.util.ArrayList;

public class Ans {
	
	private int ansNo;
	private int memberNO;
	private String ansTitle;
	private String ansContent;
	private Date ansDate;
	private String memberId;
	
	public Ans() {
		// TODO Auto-generated constructor stub
	}

	public Ans(int ansNo, int memberNO, String ansTitle, String ansContent, Date ansDate, String memberId) {
		super();
		this.ansNo = ansNo;
		this.memberNO = memberNO;
		this.ansTitle = ansTitle;
		this.ansContent = ansContent;
		this.ansDate = ansDate;
		this.memberId = memberId;
	}

	public int getAnsNo() {
		return ansNo;
	}

	public void setAnsNo(int ansNo) {
		this.ansNo = ansNo;
	}

	public int getMemberNO() {
		return memberNO;
	}

	public void setMemberNO(int memberNO) {
		this.memberNO = memberNO;
	}

	public String getAnsTitle() {
		return ansTitle;
	}

	public void setAnsTitle(String ansTitle) {
		this.ansTitle = ansTitle;
	}

	public String getAnsContent() {
		return ansContent;
	}

	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}

	public Date getAnsDate() {
		return ansDate;
	}

	public void setAnsDate(Date ansDate) {
		this.ansDate = ansDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Ans [ansNo=" + ansNo + ", memberNO=" + memberNO + ", ansTitle=" + ansTitle + ", ansContent="
				+ ansContent + ", ansDate=" + ansDate + ", memberId=" + memberId + "]";
	}
	
	
}
