package com.souleaf.spring.boast.store;

import java.util.ArrayList;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastSearch;


public interface BoastStore {

	public ArrayList<Boast> selectList(); 
	public ArrayList<Boast> selectSearchList(BoastSearch search);
	public Boast selectOne(int boastNo); 
	public int insertBoast(Boast boast);
	public int updateBoast(Boast boast);
	public int deleteBoast(int boastNo);
	
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
