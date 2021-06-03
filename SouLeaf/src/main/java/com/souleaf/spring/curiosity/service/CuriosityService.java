package com.souleaf.spring.curiosity.service;

import java.util.ArrayList;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.domain.CuriosityReply;
import com.souleaf.spring.curiosity.domain.CuriositySearch;
import com.souleaf.spring.plant.domain.Plant;

public interface CuriosityService {
	public int getCuriosityListCount(); // 게시글 갯수 
	public ArrayList<Curiosity> printAllList(PageInfo pi);// 게시글 출력
	public Curiosity printOne(int curiosityNo);// 게시글 상세보기
	public int registerCuriosity(Curiosity curiosity);// 게시글 등록
	public int modifyCuriosity(Curiosity curiosity);// 게시글 수정
	public int removeCuriosity(int curiosityNo);// 게시글 삭제
	public ArrayList<Curiosity> printSearchAllList(CuriositySearch search);// 검색
	public ArrayList<Plant> printAllhashTagList();// 해시태그 출력
	public int addReadCount(int curiosityNo);// 조회수증가
	public ArrayList<CuriosityReply> printAllCuriosityReply(int curiosityNo);// 댓글 전체 출력
	public int registerCuriosityReply(CuriosityReply reply); // 댓글 등록
	public int modifyCuriosityReply(CuriosityReply reply); // 댓글 수정
	public int removeCuriosityReply(int curiosityNo); // 댓글 삭제
	public void addViewCount(int curiosityNo); // 조회수 증가
	
	// 마이페이지
	public ArrayList<Curiosity> printAllMyCuriosity(int memberNo); // 내가 쓴 게시글 가져오기
	
}
