package com.souleaf.spring.companion.domain;

import java.sql.Date;

public class Companion {
	
	private int companionNo; // 반려식물번호
	private int plantNo; // 식물번호
	private int memberNo; // 회원번호
	private String companionNick; // 애칭
	private Date companionDate; // 등록일
	private Date companionUpdate; // 수정일
	private String companionPickName; // 식물 원본 사진
	private String companionRepicName; // 식물 저장 사진
	private Date companionLastWater; // 마지막 물 준날
	private Date companionNeedWater; // 물 줘야하는 날
	
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

	public Date getCompanionLastWater() {
		return companionLastWater;
	}

	public void setCompanionLastWater(Date companionLastWater) {
		this.companionLastWater = companionLastWater;
	}

	public Date getCompanionNeedWater() {
		return companionNeedWater;
	}

	public void setCompanionNeedWater(Date companionNeedWater) {
		this.companionNeedWater = companionNeedWater;
	}

	@Override
	public String toString() {
		return "Companion [companionNo=" + companionNo + ", plantNo=" + plantNo + ", memberNo=" + memberNo
				+ ", companionNick=" + companionNick + ", companionDate=" + companionDate + ", companionUpdate="
				+ companionUpdate + ", companionPickName=" + companionPickName + ", companionRepicName="
				+ companionRepicName + ", companionLastWater=" + companionLastWater + ", companionNeedWater="
				+ companionNeedWater + "]";
	}

}
