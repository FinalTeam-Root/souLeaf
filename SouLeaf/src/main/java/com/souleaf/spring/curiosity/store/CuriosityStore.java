package com.souleaf.spring.curiosity.store;

import java.util.ArrayList;

import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.domain.CuriosityReply;
import com.souleaf.spring.curiosity.domain.CuriositySearch;
import com.souleaf.spring.plant.domain.Plant;

public interface CuriosityStore {

	public ArrayList<Curiosity> selectAllList();// 게시글 출력
	public Curiosity selectOne(Curiosity curiosity);// 게시글 상세보기
	public int insertCuriosity(Curiosity curiosity);// 게시글 등록
	public int updateCuriosity(Curiosity curiosity);// 게시글 수정
	public int deleteCuriosity(int curiosityNo);// 게시글 삭제
	public ArrayList<Curiosity> selectSearchAllList(CuriositySearch search);// 검색
	public ArrayList<Plant> selectAllhashTagList();// 해시태그 출력
	public int addReadCount(int curiosityNo);// 조회수증가
	public ArrayList<CuriosityReply> selectAllCuriosityReply(int curiosityNo);// 댓글 전체 출력
	public int insertCuriosityReply(CuriosityReply reply); // 댓글 등록
	public int updateCuriosityReply(CuriosityReply reply); // 댓글 수정
	public int deleteCuriosityReply(int curiosityNo); // 댓글 삭제
}
