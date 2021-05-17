package com.souleaf.spring.qna.domain;

import java.sql.Date;

public class Qna {

	private int qnaNo;
	private int memberNO;
	private String qnaTitle;
	private String qnaContent;
	private Date qnaDate;
	private String memberId;
	
	
	public Qna() {}

	public Qna(int qnaNo, int memberNO, String qnaTitle, String qnaContent, Date qnaDate, String memberId, int ansNo,
			String ansTitle, String ansContent, Date ansDate) {
		super();
		this.qnaNo = qnaNo;
		this.memberNO = memberNO;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.memberId = memberId;
		
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public Qna(int qnaNo, int memberNO, String qnaTitle, String qnaContent, Date qnaDate, String memberId) {
		super();
		this.qnaNo = qnaNo;
		this.memberNO = memberNO;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.memberId = memberId;
	}

	public int getMemberNO() {
		return memberNO;
	}

	public void setMemberNO(int memberNO) {
		this.memberNO = memberNO;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public Date getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	@Override
	public String toString() {
		return "Qna [qnaNo=" + qnaNo + ", memberNO=" + memberNO + ", qnaTitle=" + qnaTitle + ", qnaContent="
				+ qnaContent + ", qnaDate=" + qnaDate + ", memberId=" + memberId + "]";
	}

	
	
}
