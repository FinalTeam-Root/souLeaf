package com.souleaf.spring.boast.domain;

import java.sql.Timestamp;

public class BoastReply {

	private int bocommentNo; // 댓글 번호
	private int boastNo; // 글 번호
	private int bocommentSuper; // 부모 댓글
	private String bocommentContent; // 댓글 내용
	private Timestamp bocommentDate; // 댓글 작성일 
	
	public BoastReply() {}
	
}
