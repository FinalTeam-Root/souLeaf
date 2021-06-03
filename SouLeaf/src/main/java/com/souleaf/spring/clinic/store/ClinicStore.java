package com.souleaf.spring.clinic.store;

import java.util.ArrayList;

import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.domain.ClinicReply;
import com.souleaf.spring.clinic.domain.ClinicSearch;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.plant.domain.Plant;

public interface ClinicStore {

	public int selectClinicListCount();
	public ArrayList<Clinic> selectAllList(PageInfo pi);// 게시글 출력
	public Clinic selectOne(int clinicNo);// 게시글 상세보기
	public int insertClinic(Clinic clinic);// 게시글 등록
	public int updateClinic(Clinic clinic);// 게시글 수정
	public int deleteClinic(int clinicNo);// 게시글 삭제
	public ArrayList<Clinic> selectSearchAllList(ClinicSearch search);// 검색
	public ArrayList<Plant> selectAllhashTagList();// 해시태그 출력
	public int addReadCount(int clinicNo);// 조회수증가
	public ArrayList<ClinicReply> selectAllClinicReply(int clinicNo);// 댓글 전체 출력
	public int insertClinicReply(ClinicReply reply); // 댓글 등록
	public int updateClinicReply(ClinicReply reply); // 댓글 수정
	public int deleteClinicReply(int clinicNo); // 댓글 삭제
	public void updateViewCount(int clinicNo); // 조회수 증가
}
