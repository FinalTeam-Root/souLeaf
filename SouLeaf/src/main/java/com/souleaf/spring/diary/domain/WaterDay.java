package com.souleaf.spring.diary.domain;

import java.sql.Date;

public class WaterDay {
	private int companionNo;
	private String diaryStartWater;
	private int diaryNo;
	private Date diaryEndWater;
	
	public WaterDay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCompanionNo() {
		return companionNo;
	}

	public void setCompanionNo(int companionNo) {
		this.companionNo = companionNo;
	}

	public String getDiaryStartWater() {
		return diaryStartWater;
	}

	public void setDiaryStartWater(String diaryStartWater) {
		this.diaryStartWater = diaryStartWater;
	}

	public int getDiaryNo() {
		return diaryNo;
	}

	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}

	public Date getDiaryEndWater() {
		return diaryEndWater;
	}

	public void setDiaryEndWater(Date diaryEndWater) {
		this.diaryEndWater = diaryEndWater;
	}

	@Override
	public String toString() {
		return "WaterDay [companionNo=" + companionNo + ", diaryStartWater=" + diaryStartWater + ", diaryNo=" + diaryNo
				+ ", diaryEndWater=" + diaryEndWater + "]";
	}

	
	
}
