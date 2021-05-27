package com.souleaf.spring.curiosity.domain;

import java.sql.Date;

public class Curiosity {
	private int curiosityNo;
	private String curiosityContent;
	private String curiosityFileName;	
	private String curiosityFileRename;
	private Date curiosityDate;
	private Date curiosityUpdate;
	private String criosityStatus;
	private int memberNo;
	private String memberNick;
	private int curiosityCount;
	private String curiosityContents;
	
	public Curiosity() {
		// TODO Auto-generated constructor stub
	}

	public Curiosity(int curiosityNo, String curiosityContent, String curiosityFileName, String curiosityFileRename,
			Date curiosityDate, Date curiosityUpdate, String criosityStatus, int memberNo, String memberNick,
			int curiosityCount, String curiosityContents) {
		super();
		this.curiosityNo = curiosityNo;
		this.curiosityContent = curiosityContent;
		this.curiosityFileName = curiosityFileName;
		this.curiosityFileRename = curiosityFileRename;
		this.curiosityDate = curiosityDate;
		this.curiosityUpdate = curiosityUpdate;
		this.criosityStatus = criosityStatus;
		this.memberNo = memberNo;
		this.memberNick = memberNick;
		this.curiosityCount = curiosityCount;
		this.curiosityContents = curiosityContents;
	}

	public int getCuriosityNo() {
		return curiosityNo;
	}

	public void setCuriosityNo(int curiosityNo) {
		this.curiosityNo = curiosityNo;
	}

	public String getCuriosityContent() {
		return curiosityContent;
	}

	public void setCuriosityContent(String curiosityContent) {
		this.curiosityContent = curiosityContent;
	}

	public String getCuriosityFileName() {
		return curiosityFileName;
	}

	public void setCuriosityFileName(String curiosityFileName) {
		this.curiosityFileName = curiosityFileName;
	}

	public String getCuriosityFileRename() {
		return curiosityFileRename;
	}

	public void setCuriosityFileRename(String curiosityFileRename) {
		this.curiosityFileRename = curiosityFileRename;
	}

	public Date getCuriosityDate() {
		return curiosityDate;
	}

	public void setCuriosityDate(Date curiosityDate) {
		this.curiosityDate = curiosityDate;
	}

	public Date getCuriosityUpdate() {
		return curiosityUpdate;
	}

	public void setCuriosityUpdate(Date curiosityUpdate) {
		this.curiosityUpdate = curiosityUpdate;
	}

	public String getCriosityStatus() {
		return criosityStatus;
	}

	public void setCriosityStatus(String criosityStatus) {
		this.criosityStatus = criosityStatus;
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

	public int getCuriosityCount() {
		return curiosityCount;
	}

	public void setCuriosityCount(int curiosityCount) {
		this.curiosityCount = curiosityCount;
	}

	public String getCuriosityContents() {
		return curiosityContents;
	}

	public void setCuriosityContents(String curiosityContents) {
		this.curiosityContents = curiosityContents;
	}

	@Override
	public String toString() {
		return "Curiosity [curiosityNo=" + curiosityNo + ", curiosityContent=" + curiosityContent
				+ ", curiosityFileName=" + curiosityFileName + ", curiosityFileRename=" + curiosityFileRename
				+ ", curiosityDate=" + curiosityDate + ", curiosityUpdate=" + curiosityUpdate + ", criosityStatus="
				+ criosityStatus + ", memberNo=" + memberNo + ", memberNick=" + memberNick + ", curiosityCount="
				+ curiosityCount + ", curiosityContents=" + curiosityContents + "]";
	}

	

	
	
}
