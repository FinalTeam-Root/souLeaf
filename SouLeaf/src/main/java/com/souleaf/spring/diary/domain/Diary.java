package com.souleaf.spring.diary.domain;

import java.sql.Date;

public class Diary {
	
	private int diaryNo;
	private String diaryTitle;
	private String diaryContent;
	private String diaryStartDate;
	private String diaryEndDate;
	private String diaryUpdate;
	private String diarycolor;
	private String diaryPicname;
	private String diaryRepicname;
	private String memberNo;
	private String companionNo;
	 
	public Diary() {}

	public int getDiaryNo() {
		return diaryNo;
	}

	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}

	public String getDiaryTitle() {
		return diaryTitle;
	}

	public void setDiaryTitle(String diaryTitle) {
		this.diaryTitle = diaryTitle;
	}

	public String getDiaryContent() {
		return diaryContent;
	}

	public void setDiaryContent(String diaryContent) {
		this.diaryContent = diaryContent;
	}

	public String getDiaryStartDate() {
		return diaryStartDate;
	}

	public void setDiaryStartDate(String diaryStartDate) {
		this.diaryStartDate = diaryStartDate;
	}

	public String getDiaryEndDate() {
		return diaryEndDate;
	}

	public void setDiaryEndDate(String diaryEndDate) {
		this.diaryEndDate = diaryEndDate;
	}

	public String getDiaryUpdate() {
		return diaryUpdate;
	}

	public void setDiaryUpdate(String diaryUpdate) {
		this.diaryUpdate = diaryUpdate;
	}

	public String getDiarycolor() {
		return diarycolor;
	}

	public void setDiarycolor(String diarycolor) {
		this.diarycolor = diarycolor;
	}

	public String getDiaryPicname() {
		return diaryPicname;
	}

	public void setDiaryPicname(String diaryPicname) {
		this.diaryPicname = diaryPicname;
	}

	public String getDiaryRepicname() {
		return diaryRepicname;
	}

	public void setDiaryRepicname(String diaryRepicname) {
		this.diaryRepicname = diaryRepicname;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getCompanionNo() {
		return companionNo;
	}

	public void setCompanionNo(String companionNo) {
		this.companionNo = companionNo;
	}

	@Override
	public String toString() {
		return "Diary [diaryNo=" + diaryNo + ", diaryTitle=" + diaryTitle + ", diaryContent=" + diaryContent
				+ ", diaryStartDate=" + diaryStartDate + ", diaryEndDate=" + diaryEndDate + ", diaryUpdate="
				+ diaryUpdate + ", diarycolor=" + diarycolor + ", diaryPicname=" + diaryPicname + ", diaryRepicname="
				+ diaryRepicname + ", memberNo=" + memberNo + ", companionNo=" + companionNo + "]";
	}
	
	
	
}
