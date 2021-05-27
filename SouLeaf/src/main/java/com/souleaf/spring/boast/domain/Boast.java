package com.souleaf.spring.boast.domain;

import java.sql.Date;

public class Boast {

	private int boastNo; // 글번호
	private String boastTitle; // 글제목
	private String boastContent; // 글내용
	private String boastCount; // 조회수
	private Date boastDate; // 작성일
	private Date boastUpdate; // 수정일
	private int memberNo; // 회원번호
	private int boastPoint; // 랭킹포인트
	private String boastStatus; // 상태
	
	public Boast() {}

	public Boast(int boastNo, String boastTitle, String boastContent, String boastCount, Date boastDate,
			Date boastUpdate, int memberNo, int boastPoint, String boastStatus) {
		super();
		this.boastNo = boastNo;
		this.boastTitle = boastTitle;
		this.boastContent = boastContent;
		this.boastCount = boastCount;
		this.boastDate = boastDate;
		this.boastUpdate = boastUpdate;
		this.memberNo = memberNo;
		this.boastPoint = boastPoint;
		this.boastStatus = boastStatus;
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

	public String getBoastStatus() {
		return boastStatus;
	}

	public void setBoastStatus(String boastStatus) {
		this.boastStatus = boastStatus;
	}

	@Override
	public String toString() {
		return "Boast [boastNo=" + boastNo + ", boastTitle=" + boastTitle + ", boastContent=" + boastContent
				+ ", boastCount=" + boastCount + ", boastDate=" + boastDate + ", boastUpdate=" + boastUpdate
				+ ", memberNo=" + memberNo + ", boastPoint=" + boastPoint + ", boastStatus=" + boastStatus + "]";
	}

	public void setOriginalFilename(String originalFilename) {
		// TODO Auto-generated method stub
		
	}

	public void setRenameFilename(String renameFileName) {
		// TODO Auto-generated method stub
		
	}
	
}
			