package com.souleaf.spring.boast.store;

import java.util.ArrayList;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastReply;
import com.souleaf.spring.boast.domain.BoastSearch;
import com.souleaf.spring.common.PageInfo;


public interface BoastStore {

	
	public ArrayList<Boast> selectAll();
	public ArrayList<Boast> selectAllList(PageInfo pi);// .
	public int selectListCount(); // 전체 수 조회수.
	public ArrayList<Boast> selectSearchList(BoastSearch search); //검색조회
	public int addReadCount(int boastNo); //.
	
	public Boast selectOne(int boastNo); // 상세 조회.
	public int insertBoast(Boast boast); //.
	public int updateBoast(Boast boast); //.
	public int deleteBoast(int boastNo); //.
	
	public ArrayList<BoastReply> selectAllBoastReply(int boastNo); //.
	public int insertBoastReply(BoastReply reply); //.
	public int updateBoastReply(BoastReply reply); //.
	public int deleteBoastReply(BoastReply reply); //.
	//ArrayList<BoastReply> selectAllBoastreply(int boastNo);
	/**
	 * 게시판 NO 취득
	 * @author ohwoocheol
	 * @since 2021.8.16
	 */
	public ArrayList<Boast> selectAllNo();
	/**
	 * 좋아요 포인트 초기화
	 * @author ohwoocheol
	 * @param boastNo 
	 * @since 2021.8.15
	 */
	public int updatePoint(int boastNo);
	
	/**
	 * 3위 까지 출력
	 * @author ohwoocheol
	 * @param boastNo 
	 * @since 2021.8.15
	 */
	public ArrayList<Boast> selectRank();

	
	
	
}
