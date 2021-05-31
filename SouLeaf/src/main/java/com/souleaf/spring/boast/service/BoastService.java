package com.souleaf.spring.boast.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastReply;
import com.souleaf.spring.boast.domain.BoastSearch;
import com.souleaf.spring.common.PageInfo;


public interface BoastService {
	//public ArrayList<Boast> printAll(PageInfo pi);// 게시글 전체출력.
	public ArrayList<Boast> printAll(PageInfo pi);
	public ArrayList<Boast> printSearchAll(BoastSearch search); // 게시글 검색
	public Boast printOne(int boastNo);// 게시글 상세조회 .
	public int registerBoast(Boast boast);// 게시글 등록.
	public int modifyBoast(Boast boast);// 게시글 수정.
	public int removeBoast(int boastNo);// 게시글 삭제 .
	public ArrayList<Boast> printAllhashTagList(); // 해시태그 출력
	public int addReadCount(int boastNo); // 게시글 상세 조회시 조회수 증가.
	public ArrayList<BoastReply> printAllBoastReply(int boastNo); // 댓글 전체 출력.
	public int registerBoastReply(BoastReply reply); // 댓글 등록.
	public int modifyBoastReply(BoastReply reply); // 댓글 수정.
	public int removeBoastReply(BoastReply reply); // 댓글 삭제.
	public int likeNo(Boast boast); // 좋아요
	public int getListCount(); // 게시물 갯수 조회
	
	
	/**
	 * 게시판 NO 취득
	 * @author ohwoocheol
	 * @since 2021.8.16
	 */
	public ArrayList<Boast> printAllNo(); // 게시글NO만 취득
	/**
	 * 좋아요 포인트 초기화
	 * @author ohwoocheol
	 * @param boastNo 
	 * @since 2021.8.15
	 */
	public int pointReset(int boastNo); // 좋아요 포인트 리셋
	/**
	 * 3위 까지 출력
	 * @author ohwoocheol
	 * @param boastNo 
	 * @since 2021.8.15
	 */
	public ArrayList<Boast> printRank();
//	ArrayList<Boast> printAll();
	//int removeBoastReply(BoastReply reply);
	ArrayList<Boast> printAll();
	
	
	
	

}
