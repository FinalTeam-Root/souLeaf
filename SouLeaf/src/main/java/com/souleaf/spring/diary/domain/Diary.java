package com.souleaf.spring.diary.domain;

import java.sql.Date;

public class Diary {
	
	private int diaryNo;
	private String diaryTitle;
	private String diaryContent;
	private String diaryDate;
	private String diaryUpdate;
	private String diaryRepicname;
	 
	public Diary() {}

	public Diary(String diaryTitle, String diaryContent, String diaryDate, String diaryUpdate, String diaryRepicname) {
		super();
		this.diaryTitle = diaryTitle;
		this.diaryContent = diaryContent;
		this.diaryDate = diaryDate;
		this.diaryUpdate = diaryUpdate;
		this.diaryRepicname = diaryRepicname;
	}

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

	public String getDiaryDate() {
		return diaryDate;
	}

	public void setDiaryDate(String diaryDate) {
		this.diaryDate = diaryDate;
	}

	public String getDiaryUpdate() {
		return diaryUpdate;
	}

	public void setDiaryUpdate(String diaryUpdate) {
		this.diaryUpdate = diaryUpdate;
	}

	public String getDiaryRepicname() {
		return diaryRepicname;
	}

	public void setDiaryRepicname(String diaryRepicname) {
		this.diaryRepicname = diaryRepicname;
	}

	@Override
	public String toString() {
		return "Diary [diaryNo=" + diaryNo + ", diaryTitle=" + diaryTitle + ", diaryContent=" + diaryContent
				+ ", diaryDate=" + diaryDate + ", diaryUpdate=" + diaryUpdate + ", diaryRepicname=" + diaryRepicname
				+ "]";
	}

	
}
