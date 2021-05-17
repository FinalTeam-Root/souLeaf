package com.souleaf.spring.clinic.domain;

import java.sql.Date;

public class ClinicFile {
	
	private int clinicfileNo;
	private int clinicNo;
	private String clinicfileOriginalName;
	private String clinicfileRenameName;
	private int clinicfileSize;
	private Date clinicfileDate;
	
	public ClinicFile() {}

	public int getClinicfileNo() {
		return clinicfileNo;
	}

	public void setClinicfileNo(int clinicfileNo) {
		this.clinicfileNo = clinicfileNo;
	}

	public int getClinicNo() {
		return clinicNo;
	}

	public void setClinicNo(int clinicNo) {
		this.clinicNo = clinicNo;
	}

	public String getClinicfileOriginalName() {
		return clinicfileOriginalName;
	}

	public void setClinicfileOriginalName(String clinicfileOriginalName) {
		this.clinicfileOriginalName = clinicfileOriginalName;
	}

	public String getClinicfileRenameName() {
		return clinicfileRenameName;
	}

	public void setClinicfileRenameName(String clinicfileRenameName) {
		this.clinicfileRenameName = clinicfileRenameName;
	}

	public int getClinicfileSize() {
		return clinicfileSize;
	}

	public void setClinicfileSize(int clinicfileSize) {
		this.clinicfileSize = clinicfileSize;
	}

	public Date getClinicfileDate() {
		return clinicfileDate;
	}

	public void setClinicfileDate(Date clinicfileDate) {
		this.clinicfileDate = clinicfileDate;
	}

	@Override
	public String toString() {
		return "ClinicFile [clinicfileNo=" + clinicfileNo + ", clinicNo=" + clinicNo + ", clinicfileOriginalName="
				+ clinicfileOriginalName + ", clinicfileRenameName=" + clinicfileRenameName + ", clinicfileSize="
				+ clinicfileSize + ", clinicfileDate=" + clinicfileDate + "]";
	}

}
