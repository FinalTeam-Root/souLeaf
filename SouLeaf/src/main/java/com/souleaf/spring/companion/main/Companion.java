package com.souleaf.spring.companion.main;

import java.sql.Date;

public class Companion {
	
	private int companionNo;
	private int plantNo;
	private int memberNo;
	private String companionNick;
	private Date companionDate;
	private Date companionUpdate;
	private String companionPickName;
	private String companionRepicName;
	
	public Companion() {}

	public int getCompanionNo() {
		return companionNo;
	}

	public void setCompanionNo(int companionNo) {
		this.companionNo = companionNo;
	}

	public int getPlantNo() {
		return plantNo;
	}

	public void setPlantNo(int plantNo) {
		this.plantNo = plantNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getCompanionNick() {
		return companionNick;
	}

	public void setCompanionNick(String companionNick) {
		this.companionNick = companionNick;
	}

	public Date getCompanionDate() {
		return companionDate;
	}

	public void setCompanionDate(Date companionDate) {
		this.companionDate = companionDate;
	}

	public Date getCompanionUpdate() {
		return companionUpdate;
	}

	public void setCompanionUpdate(Date companionUpdate) {
		this.companionUpdate = companionUpdate;
	}

	public String getCompanionPickName() {
		return companionPickName;
	}

	public void setCompanionPickName(String companionPickName) {
		this.companionPickName = companionPickName;
	}

	public String getCompanionRepicName() {
		return companionRepicName;
	}

	public void setCompanionRepicName(String companionRepicName) {
		this.companionRepicName = companionRepicName;
	}

	@Override
	public String toString() {
		return "Companion [companionNo=" + companionNo + ", plantNo=" + plantNo + ", memberNo=" + memberNo
				+ ", companionNick=" + companionNick + ", companionDate=" + companionDate + ", companionUpdate="
				+ companionUpdate + ", companionPickName=" + companionPickName + ", companionRepicName="
				+ companionRepicName + "]";
	}
	
}
