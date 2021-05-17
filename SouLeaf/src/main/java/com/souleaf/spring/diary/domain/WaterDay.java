package com.souleaf.spring.diary.domain;

import java.sql.Date;

public class WaterDay {
	private int companionNo;
	private Date diaryLastWater;
	
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

	public Date getDiaryLastWater() {
		return diaryLastWater;
	}

	public void setDiaryLastWater(Date diaryLastWater) {
		this.diaryLastWater = diaryLastWater;
	}

	@Override
	public String toString() {
		return "WarterDay [companionNo=" + companionNo + ", diaryLastWater=" + diaryLastWater + "]";
	}
	
	
}
