package com.souleaf.spring.curiosity.domain;

import java.sql.Timestamp;

public class CuriosityReply {
	private int curicommentNo;
	private String curiocommentContent;
	private Timestamp curicommentDate;
	private int curiosityNo;
	private int memberNo;
	private String memberName;
	
	public CuriosityReply() {
		// TODO Auto-generated constructor stub
	}

	public CuriosityReply(int curicommentNo, String curiocommentContent, Timestamp curicommentDate, int curiosityNo,
			int memberNo, String memberName) {
		super();
		this.curicommentNo = curicommentNo;
		this.curiocommentContent = curiocommentContent;
		this.curicommentDate = curicommentDate;
		this.curiosityNo = curiosityNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
	}

	public int getCuricommentNo() {
		return curicommentNo;
	}

	public void setCuricommentNo(int curicommentNo) {
		this.curicommentNo = curicommentNo;
	}

	public String getCuriocommentContent() {
		return curiocommentContent;
	}

	public void setCuriocommentContent(String curiocommentContent) {
		this.curiocommentContent = curiocommentContent;
	}

	public Timestamp getCuricommentDate() {
		return curicommentDate;
	}

	public void setCuricommentDate(Timestamp curicommentDate) {
		this.curicommentDate = curicommentDate;
	}

	public int getCuriosityNo() {
		return curiosityNo;
	}

	public void setCuriosityNo(int curiosityNo) {
		this.curiosityNo = curiosityNo;
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

	@Override
	public String toString() {
		return "CuriosityReply [curicommentNo=" + curicommentNo + ", curiocommentContent=" + curiocommentContent
				+ ", curicommentDate=" + curicommentDate + ", curiosityNo=" + curiosityNo + ", memberNo=" + memberNo
				+ ", memberName=" + memberName + "]";
	}

	
	
}
