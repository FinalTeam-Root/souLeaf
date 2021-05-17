package com.souleaf.spring.clinic.domain;

public class ClinicCommnet {

	private int clinicCommnetNo;		// 댓글번호
	private int clinicCommnetContent;	// 댓글내용
	private String clinicCommnetCreate; // 작성일
	private String clinicCommnetUpdate; // 수정일
	private String clinicCommnetStatus; // 상태
	private int clinicNo;				// 클리닉번호
	private int memberNo;				// 회원번호
	private String memberNick;			// 회원닉네임
	
	public ClinicCommnet() {}
	
	public int getClinicCommnetNo() {
		return clinicCommnetNo;
	}
	public void setClinicCommnetNo(int clinicCommnetNo) {
		this.clinicCommnetNo = clinicCommnetNo;
	}
	public int getClinicCommnetContent() {
		return clinicCommnetContent;
	}
	public void setClinicCommnetContent(int clinicCommnetContent) {
		this.clinicCommnetContent = clinicCommnetContent;
	}
	public String getClinicCommnetCreate() {
		return clinicCommnetCreate;
	}
	public void setClinicCommnetCreate(String clinicCommnetCreate) {
		this.clinicCommnetCreate = clinicCommnetCreate;
	}
	public String getClinicCommnetUpdate() {
		return clinicCommnetUpdate;
	}
	public void setClinicCommnetUpdate(String clinicCommnetUpdate) {
		this.clinicCommnetUpdate = clinicCommnetUpdate;
	}
	public String getClinicCommnetStatus() {
		return clinicCommnetStatus;
	}
	public void setClinicCommnetStatus(String clinicCommnetStatus) {
		this.clinicCommnetStatus = clinicCommnetStatus;
	}
	public int getClinicNo() {
		return clinicNo;
	}
	public void setClinicNo(int clinicNo) {
		this.clinicNo = clinicNo;
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
	@Override
	public String toString() {
		return "ClinicCommnet [clinicCommnetNo=" + clinicCommnetNo + ", clinicCommnetContent=" + clinicCommnetContent
				+ ", clinicCommnetCreate=" + clinicCommnetCreate + ", clinicCommnetUpdate=" + clinicCommnetUpdate
				+ ", clinicCommnetStatus=" + clinicCommnetStatus + ", clinicNo=" + clinicNo + ", memberNo=" + memberNo
				+ ", memberNick=" + memberNick + "]";
	}
	
}
