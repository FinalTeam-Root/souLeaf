package com.souleaf.spring.clinic.domain;

import java.sql.Date;

public class Clinic {
	private int clinicNo;
	private int MemberNo;
	private String clinicTitle;
	private String clinicContent;
	private String clinicPlant;
	private Date clinicDate;
	private String clinicPlace;
	private String clinicRepot;
	private String clinicWater;
	
	public Clinic() {}

	public int getClinicNo() {
		return clinicNo;
	}

	public void setClinicNo(int clinicNo) {
		this.clinicNo = clinicNo;
	}

	public int getMemberNo() {
		return MemberNo;
	}

	public void setMemberNo(int memberNo) {
		MemberNo = memberNo;
	}

	public String getClinicTitle() {
		return clinicTitle;
	}

	public void setClinicTitle(String clinicTitle) {
		this.clinicTitle = clinicTitle;
	}

	public String getClinicContent() {
		return clinicContent;
	}

	public void setClinicContent(String clinicContent) {
		this.clinicContent = clinicContent;
	}

	public String getClinicPlant() {
		return clinicPlant;
	}

	public void setClinicPlant(String clinicPlant) {
		this.clinicPlant = clinicPlant;
	}

	public Date getClinicDate() {
		return clinicDate;
	}

	public void setClinicDate(Date clinicDate) {
		this.clinicDate = clinicDate;
	}

	public String getClinicPlace() {
		return clinicPlace;
	}

	public void setClinicPlace(String clinicPlace) {
		this.clinicPlace = clinicPlace;
	}

	public String getClinicRepot() {
		return clinicRepot;
	}

	public void setClinicRepot(String clinicRepot) {
		this.clinicRepot = clinicRepot;
	}

	public String getClinicWater() {
		return clinicWater;
	}

	public void setClinicWater(String clinicWater) {
		this.clinicWater = clinicWater;
	}

	@Override
	public String toString() {
		return "Clinic [clinicNo=" + clinicNo + ", MemberNo=" + MemberNo + ", clinicTitle=" + clinicTitle
				+ ", clinicContent=" + clinicContent + ", clinicPlant=" + clinicPlant + ", clinicDate=" + clinicDate
				+ ", clinicPlace=" + clinicPlace + ", clinicRepot=" + clinicRepot + ", clinicWater=" + clinicWater
				+ "]";
	}
	
}
