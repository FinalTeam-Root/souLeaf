package com.souleaf.spring.member.domain;

import java.sql.Date;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberNick;
	private String mamberName;
	private String memberPhoto;
	private String memberMail;
	private Date memberJoin;
	private Date memberOut;
	private String memberStatus;

	public Member() {}
	
		
	

	public Member(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}




	public Member(int memberNo, String memberId, String memberPw, String memberNick, String mamberName, String memberPhoto,
			String memberMail, Date memberJoin, Date memberOut, String memberStatus) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberNick = memberNick;
		this.mamberName = mamberName;
		this.memberPhoto = memberPhoto;
		this.memberMail = memberMail;
		this.memberJoin = memberJoin;
		this.memberOut = memberOut;
		this.memberStatus = memberStatus;
	}







	public int getMemberNo() {
		return memberNo;
	}




	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}




	public String getMemberId() {
		return memberId;
	}




	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}




	public String getMemberPw() {
		return memberPw;
	}




	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}




	public String getMemberNick() {
		return memberNick;
	}




	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}




	public String getMamberName() {
		return mamberName;
	}




	public void setMamberName(String mamberName) {
		this.mamberName = mamberName;
	}




	public String getMemberPhoto() {
		return memberPhoto;
	}




	public void setMemberPhoto(String memberPhoto) {
		this.memberPhoto = memberPhoto;
	}




	public String getMemberMail() {
		return memberMail;
	}




	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}




	public Date getMemberJoin() {
		return memberJoin;
	}




	public void setMemberJoin(Date memberJoin) {
		this.memberJoin = memberJoin;
	}




	public Date getMemberOut() {
		return memberOut;
	}




	public void setMemberOut(Date memberOut) {
		this.memberOut = memberOut;
	}




	public String getMemberStatus() {
		return memberStatus;
	}




	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}




	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberNick="
				+ memberNick + ", mamberName=" + mamberName + ", memberPhoto=" + memberPhoto + ", memberMail="
				+ memberMail + ", memberJoin=" + memberJoin + ", memberOut=" + memberOut + ", memberStatus="
				+ memberStatus + "]";
	}



	
	


	

}
