package com.souleaf.spring.boast.domain;

import java.sql.Timestamp;

public class BoastReply {

	private int bocommentNo; // 댓글 번호
	private int boastNo; // 글 번호
	private String bocommentContent; // 댓글 내용
	private Timestamp bocommentDate; // 댓글 작성일 
	private int memberNo;
	private String memberName;
	private String bocommentStatus;
	
	
	public BoastReply() {}


	public BoastReply(int bocommentNo, int boastNo, String bocommentContent, Timestamp bocommentDate, int memberNo,
			String memberName, String bocommentStatus) {
		super();
		this.bocommentNo = bocommentNo;
		this.boastNo = boastNo;
		this.bocommentContent = bocommentContent;
		this.bocommentDate = bocommentDate;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.bocommentStatus = bocommentStatus;
	}


	public int getBocommentNo() {
		return bocommentNo;
	}


	public void setBocommentNo(int bocommentNo) {
		this.bocommentNo = bocommentNo;
	}


	public int getBoastNo() {
		return boastNo;
	}


	public void setBoastNo(int boastNo) {
		this.boastNo = boastNo;
	}


	public String getBocommentContent() {
		return bocommentContent;
	}


	public void setBocommentContent(String bocommentContent) {
		this.bocommentContent = bocommentContent;
	}


	public Timestamp getBocommentDate() {
		return bocommentDate;
	}


	public void setBocommentDate(Timestamp bocommentDate) {
		this.bocommentDate = bocommentDate;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getBocommentStatus() {
		return bocommentStatus;
	}


	public void setBocommentStatus(String bocommentStatus) {
		this.bocommentStatus = bocommentStatus;
	}


	@Override
	public String toString() {
		return "BoastReply [bocommentNo=" + bocommentNo + ", boastNo=" + boastNo + ", bocommentContent="
				+ bocommentContent + ", bocommentDate=" + bocommentDate + ", memberNo=" + memberNo + ", memberName="
				+ memberName + ", bocommentStatus=" + bocommentStatus + "]";
	}

	
	

	
}
