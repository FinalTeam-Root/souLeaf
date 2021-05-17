package com.souleaf.spring.clinic.store;

import java.util.ArrayList;

import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.domain.ClinicCommnet;
import com.souleaf.spring.common.PageInfo;

public interface ClinicStore {

	   public int selectListCount(); // 클리닉 전체 수 조회수
	   public ArrayList<Clinic> selectAllList(PageInfo pi); // 클리닉 전체 조회
	   public int addReadCount(int clinicNo); // 클리닉 상세 조회시 조회수 증가
	   
	   public Clinic selectOne(int clinicNo); // 클리닉 상세 조회
	   public int insertBoard(Clinic clinic); // 클리닉 등록
	   public int updateBoard(Clinic clinic); // 클리닉 수정
	   public int deleteBoard(int clinicNo); // 클리닉 삭제
	   
	   public ArrayList<ClinicCommnet> selectAllReply(int clinicNo); //  클리닉 댓글 전체 조회
	   public int insertReply(ClinicCommnet clinicCommnet); // 클리닉 댓글 등록
	   public int updateReply(ClinicCommnet clinicCommnet); // 클리닉 댓글 수정
	   public int deleteReply(ClinicCommnet clinicCommnet); // 클리닉 댓글 삭제
}
