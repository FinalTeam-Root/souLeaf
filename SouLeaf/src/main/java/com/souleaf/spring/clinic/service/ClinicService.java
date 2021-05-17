package com.souleaf.spring.clinic.service;

import java.util.ArrayList;

import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.domain.ClinicCommnet;
import com.souleaf.spring.common.PageInfo;

public interface ClinicService {
	
	public int getListCount(); // 클리닉 게시물 개수 조회
	public ArrayList<Clinic> printAll(PageInfo pi); // 클리닉 전체 조회
	public int addReadCount(int clinicNo); // 클리닉 상세 조회시 조회수 증가
	
	public Clinic printOne(int clinicNo); // 클리닉 상세 조회
	public int registerBoard(Clinic clinic); // 클리닉 등록
	public int modifyBoard(Clinic clinic); // 클리닉 수정
	public int removeBoard(int clinicNo); // 클리닉 삭제
	
	public ArrayList<ClinicCommnet> printAllReply(int clinicNo); // 클리닉 댓글 전체 조회
	public int registerReply(ClinicCommnet clinicCommnet); // 클리닉 댓글 등록
	public int modifyReply(ClinicCommnet clinicCommnet); // 클리닉 댓글 수정
	public int removeReply(ClinicCommnet clinicCommnet); // 클리닉 댓글 삭제

}
