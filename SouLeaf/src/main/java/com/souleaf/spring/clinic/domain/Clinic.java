package com.souleaf.spring.clinic.domain;

import java.sql.Date;

public class Clinic {
	private int clinicNo;
	private String clinicContent;
	private String clinicFileName;
	private String clinicFileRename;
	private Date clinicDate;
	private Date clinicUpdate;
	private String clinicStatus;
	private int memberNo;
	private String memberNick;
	private int clinicCount;
	private String clinicContents;
	private int replyCount;
	private int num;
	private int clinicLike;

	public Clinic() {
	}

	public Clinic(int clinicNo, String clinicContent, String clinicFileName, String clinicFileRename, Date clinicDate,
			Date clinicUpdate, String clinicStatus, int memberNo, String memberNick, int clinicCount,
			String clinicContents, int replyCount, int num, int clinicLike) {
		this.clinicNo = clinicNo;
		this.clinicContent = clinicContent;
		this.clinicFileName = clinicFileName;
		this.clinicFileRename = clinicFileRename;
		this.clinicDate = clinicDate;
		this.clinicUpdate = clinicUpdate;
		this.clinicStatus = clinicStatus;
		this.memberNo = memberNo;
		this.memberNick = memberNick;
		this.clinicCount = clinicCount;
		this.clinicContents = clinicContents;
		this.replyCount = replyCount;
		this.num = num;
		this.clinicLike = clinicLike;
	}

	public int getClinicNo() {
		return clinicNo;
	}

	public void setClinicNo(int clinicNo) {
		this.clinicNo = clinicNo;
	}

	public String getClinicContent() {
		return clinicContent;
	}

	public void setClinicContent(String clinicContent) {
		this.clinicContent = clinicContent;
	}

	public String getClinicFileName() {
		return clinicFileName;
	}

	public void setClinicFileName(String clinicFileName) {
		this.clinicFileName = clinicFileName;
	}

	public String getClinicFileRename() {
		return clinicFileRename;
	}

	public void setClinicFileRename(String clinicFileRename) {
		this.clinicFileRename = clinicFileRename;
	}

	public Date getClinicDate() {
		return clinicDate;
	}

	public void setClinicDate(Date clinicDate) {
		this.clinicDate = clinicDate;
	}

	public Date getClinicUpdate() {
		return clinicUpdate;
	}

	public void setClinicUpdate(Date clinicUpdate) {
		this.clinicUpdate = clinicUpdate;
	}

	public String getClinicStatus() {
		return clinicStatus;
	}

	public void setClinicStatus(String clinicStatus) {
		this.clinicStatus = clinicStatus;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public int getClinicCount() {
		return clinicCount;
	}

	public void setClinicCount(int clinicCount) {
		this.clinicCount = clinicCount;
	}

	public String getClinicContents() {
		return clinicContents;
	}

	public void setClinicContents(String clinicContents) {
		this.clinicContents = clinicContents;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getClinicLike() {
		return clinicLike;
	}

	public void setClinicLike(int clinicLike) {
		this.clinicLike = clinicLike;
	}

	@Override
	public String toString() {
		return "Clinic [clinicNo=" + clinicNo + ", clinicContent=" + clinicContent + ", clinicFileName="
				+ clinicFileName + ", clinicFileRename=" + clinicFileRename + ", clinicDate=" + clinicDate
				+ ", clinicUpdate=" + clinicUpdate + ", clinicStatus=" + clinicStatus + ", memberNo=" + memberNo
				+ ", memberNick=" + memberNick + ", clinicCount=" + clinicCount + ", clinicContents=" + clinicContents
				+ ", replyCount=" + replyCount + ", num=" + num + ", clinicLike=" + clinicLike + "]";
	}

}
