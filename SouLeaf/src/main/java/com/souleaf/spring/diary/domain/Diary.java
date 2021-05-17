package com.souleaf.spring.diary.domain;

import java.sql.Date;

public class Diary {
	
	private int diaryNo;
	private String diaryTitle;
	private String diaryContent;
	private Date diaryDate;
	private String diaryPath;
	private long diarySize;
	private Date diaryLastWater;
	 
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

	public Date getDiaryDate() {
		return diaryDate;
	}

	public void setDiaryDate(Date diaryDate) {
		this.diaryDate = diaryDate;
	}

	public String getDiaryPath() {
		return diaryPath;
	}

	public void setDiaryPath(String diaryPath) {
		this.diaryPath = diaryPath;
	}

	public long getDiarySize() {
		return diarySize;
	}

	public void setDiarySize(long diarySize) {
		this.diarySize = diarySize;
	}

	public Date getDiaryLastWater() {
		return diaryLastWater;
	}

	public void setDiaryLastWater(Date diaryLastWater) {
		this.diaryLastWater = diaryLastWater;
	}

	@Override
	public String toString() {
		return "Diary [diaryNo=" + diaryNo + ", diaryTitle=" + diaryTitle + ", diaryContent=" + diaryContent
				+ ", diaryDate=" + diaryDate + ", diaryPath=" + diaryPath + ", diarySize=" + diarySize
				+ ", diaryLastWater=" + diaryLastWater + "]";
	};
	
	
}
