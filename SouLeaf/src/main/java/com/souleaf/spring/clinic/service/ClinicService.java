package com.souleaf.spring.clinic.service;

import java.util.ArrayList;

import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.domain.ClinicReply;
import com.souleaf.spring.clinic.domain.ClinicSearch;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.plant.domain.Plant;

public interface ClinicService {
	
	public int getClinicListCount(); // 게시글 갯수 
	public ArrayList<Clinic> printAllList(PageInfo pi);// 게시글 출력
	public Clinic printOne(int clinicNo);// 게시글 상세보기
	public int registerClinic(Clinic clinic);// 게시글 등록
	public int modifyClinic(Clinic clinic);// 게시글 수정
	public int removeClinic(int clinicNo);// 게시글 삭제
	public ArrayList<Clinic> printSearchAllList(ClinicSearch search);// 검색
	public ArrayList<Plant> printAllhashTagList();// 해시태그 출력
	public int addReadCount(int ClinicNo);// 조회수증가
	public ArrayList<ClinicReply> printAllClinicReply(int clinicNo);// 댓글 전체 출력
	public int registerClinicReply(ClinicReply reply); // 댓글 등록
	public int modifyClinicReply(ClinicReply reply); // 댓글 수정
	public int removeClinicReply(int clinicNo); // 댓글 삭제
	public void addViewCount(int clinicNo); // 조회수 증가
	

}
