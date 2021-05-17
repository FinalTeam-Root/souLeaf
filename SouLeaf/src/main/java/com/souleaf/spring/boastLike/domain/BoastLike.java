package com.souleaf.spring.boastLike.domain;

public class BoastLike {

	private int likeNo;
	private String likeCheck;
	private int boastNo;

	public BoastLike() {}

	public int getLikeNo() {
		return likeNo;
	}

	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}

	public String getLikeCheck() {
		return likeCheck;
	}

	public void setLikeCheck(String likeCheck) {
		this.likeCheck = likeCheck;
	}

	public int getBoastNo() {
		return boastNo;
	}

	public void setBoastNo(int boastNo) {
		this.boastNo = boastNo;
	}

	@Override
	public String toString() {
		return "BoastLike [likeNo=" + likeNo + ", likeCheck=" + likeCheck + ", boastNo=" + boastNo + "]";
	}

}
