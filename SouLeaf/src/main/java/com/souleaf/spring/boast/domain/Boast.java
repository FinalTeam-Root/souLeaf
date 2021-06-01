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
	private String memberName; // 작성자 이름
	private int boastPoint; // 랭킹포인트
	private String boastStatus; // 상태
	private int plantNo; // 식물번호
	private String boastFileName; // 사진이름 
	private String boastReName; // 서버사진이름
	private int boastReplyCount; 
	
	public Boast() {}

	public Boast(int boastNo, String boastTitle, String boastContent, String boastCount, Date boastDate,
			Date boastUpdate, int memberNo, String memberName, int boastPoint, String boastStatus, int plantNo,
			String boastFileName, String boastReName, int boastReplyCount) {
		super();
		this.boastNo = boastNo;
		this.boastTitle = boastTitle;
		this.boastContent = boastContent;
		this.boastCount = boastCount;
		this.boastDate = boastDate;
		this.boastUpdate = boastUpdate;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.boastPoint = boastPoint;
		this.boastStatus = boastStatus;
		this.plantNo = plantNo;
		this.boastFileName = boastFileName;
		this.boastReName = boastReName;
		this.boastReplyCount = boastReplyCount;
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	public int getPlantNo() {
		return plantNo;
	}

	public void setPlantNo(int plantNo) {
		this.plantNo = plantNo;
	}

	public String getBoastFileName() {
		return boastFileName;
	}

	public void setBoastFileName(String boastFileName) {
		this.boastFileName = boastFileName;
	}

	public String getBoastReName() {
		return boastReName;
	}

	public void setBoastReName(String boastReName) {
		this.boastReName = boastReName;
	}

	public int getBoastReplyCount() {
		return boastReplyCount;
	}

	public void setBoastReplyCount(int boastReplyCount) {
		this.boastReplyCount = boastReplyCount;
	}

	@Override
	public String toString() {
		return "Boast [boastNo=" + boastNo + ", boastTitle=" + boastTitle + ", boastContent=" + boastContent
				+ ", boastCount=" + boastCount + ", boastDate=" + boastDate + ", boastUpdate=" + boastUpdate
				+ ", memberNo=" + memberNo + ", memberName=" + memberName + ", boastPoint=" + boastPoint
				+ ", boastStatus=" + boastStatus + ", plantNo=" + plantNo + ", boastFileName=" + boastFileName
				+ ", boastReName=" + boastReName + ", boastReplyCount=" + boastReplyCount + "]";
	}
	
	
	}


	





	

			