package com.souleaf.spring.boast.domain;

import java.sql.Timestamp;

public class BoastReply {

	private int bocommentNo; // 댓글 번호
	private int boastNo; // 글 번호
	private int bocommentSuper; // 부모 댓글
	private String bocommentContent; // 댓글 내용
	private Timestamp bocommentDate; // 댓글 작성일 
	
	public BoastReply() {}

	public BoastReply(int bocommentNo, int boastNo, int bocommentSuper, String bocommentContent,
			Timestamp bocommentDate) {
		super();
		this.bocommentNo = bocommentNo;
		this.boastNo = boastNo;
		this.bocommentSuper = bocommentSuper;
		this.bocommentContent = bocommentContent;
		this.bocommentDate = bocommentDate;
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

	public int getBocommentSuper() {
		return bocommentSuper;
	}

	public void setBocommentSuper(int bocommentSuper) {
		this.bocommentSuper = bocommentSuper;
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

	@Override
	public String toString() {
		return "BoastReply [bocommentNo=" + bocommentNo + ", boastNo=" + boastNo + ", bocommentSuper=" + bocommentSuper
				+ ", bocommentContent=" + bocommentContent + ", bocommentDate=" + bocommentDate + "]";
	}

	

	
}
