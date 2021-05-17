package com.souleaf.spring.diary.domain;

import java.sql.Date;

public class Guestbook {
	
	private int guestbookNo;
	private String guestbookContents;
	private  Date guestbookDate;
	
	public Guestbook() {}
	
	public int getGuestbookNo() {
		return guestbookNo;
	}
	public void setGuestbookNo(int guestbookNo) {
		this.guestbookNo = guestbookNo;
	}
	public String getGuestbookContents() {
		return guestbookContents;
	}
	public void setGuestbookContents(String guestbookContents) {
		this.guestbookContents = guestbookContents;
	}
	public Date getGuestbookDate() {
		return guestbookDate;
	}
	public void setGuestbookDate(Date guestbookDate) {
		this.guestbookDate = guestbookDate;
	}

	@Override
	public String toString() {
		return "Guestbook [guestbookNo=" + guestbookNo + ", guestbookContents=" + guestbookContents + ", guestbookDate="
				+ guestbookDate + "]";
	}
	
}
