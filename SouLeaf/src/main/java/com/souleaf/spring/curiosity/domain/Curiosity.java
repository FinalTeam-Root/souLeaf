package com.souleaf.spring.curiosity.domain;

import java.sql.Date;

public class Curiosity {
	private int curiosityNo;
	private String curiosityContent;
	private String curiosityFileName;
	private String curiosityFilePath;
	private long curiosityFileSize;
	private Date curiosityDate;
	private int memberNo;
	private String memberName;
	
	public Curiosity() {
		// TODO Auto-generated constructor stub
	}

	public Curiosity(int curiosityNo, String curiosityContent, String curiosityFileName, String curiosityFilePath,
			long curiosityFileSize, Date curiosityDate, int memberNo, String memberName) {
		super();
		this.curiosityNo = curiosityNo;
		this.curiosityContent = curiosityContent;
		this.curiosityFileName = curiosityFileName;
		this.curiosityFilePath = curiosityFilePath;
		this.curiosityFileSize = curiosityFileSize;
		this.curiosityDate = curiosityDate;
		this.memberNo = memberNo;
		this.memberName = memberName;
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

	public String getCuriosityFilePath() {
		return curiosityFilePath;
	}

	public void setCuriosityFilePath(String curiosityFilePath) {
		this.curiosityFilePath = curiosityFilePath;
	}

	public long getCuriosityFileSize() {
		return curiosityFileSize;
	}

	public void setCuriosityFileSize(long curiosityFileSize) {
		this.curiosityFileSize = curiosityFileSize;
	}

	public Date getCuriosityDate() {
		return curiosityDate;
	}

	public void setCuriosityDate(Date curiosityDate) {
		this.curiosityDate = curiosityDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "Curiosity [curiosityNo=" + curiosityNo + ", curiosityContent=" + curiosityContent
				+ ", curiosityFileName=" + curiosityFileName + ", curiosityFilePath=" + curiosityFilePath
				+ ", curiosityFileSize=" + curiosityFileSize + ", curiosityDate=" + curiosityDate + ", memberNo="
				+ memberNo + ", memberName=" + memberName + "]";
	}

	

	
	
}
