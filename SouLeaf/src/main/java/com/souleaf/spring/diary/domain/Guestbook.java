package com.souleaf.spring.diary.domain;

import java.sql.Date;

public class Guestbook {
	
	private int guestbookNo;
	private String guestbookContent;
	private Date guestbookDate;
	private Date guestbookUpdate;
	private int memberNo;
	
	public Guestbook() {}

	public int getGuestbookNo() {
		return guestbookNo;
	}

	public void setGuestbookNo(int guestbookNo) {
		this.guestbookNo = guestbookNo;
	}

	public String getGuestbookContent() {
		return guestbookContent;
	}

	public void setGuestbookContent(String guestbookContent) {
		this.guestbookContent = guestbookContent;
	}

	public Date getGuestbookDate() {
		return guestbookDate;
	}

	public void setGuestbookDate(Date guestbookDate) {
		this.guestbookDate = guestbookDate;
	}

	public Date getGuestbookUpdate() {
		return guestbookUpdate;
	}

	public void setGuestbookUpdate(Date guestbookUpdate) {
		this.guestbookUpdate = guestbookUpdate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "Guestbook [guestbookNo=" + guestbookNo + ", guestbookContent=" + guestbookContent + ", guestbookDate="
				+ guestbookDate + ", guestbookUpdate=" + guestbookUpdate + ", memberNo=" + memberNo + "]";
	}
	
	
	
}
