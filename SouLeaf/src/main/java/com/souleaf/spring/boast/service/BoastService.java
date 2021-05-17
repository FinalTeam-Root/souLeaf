package com.souleaf.spring.boast.service;

import java.util.ArrayList;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastReply;
import com.souleaf.spring.boast.domain.BoastSearch;


public interface BoastService {
	public ArrayList<Boast> printAll();// 게시글 전체출력
	public ArrayList<Boast> printSearchAll(BoastSearch search); // 게시글 검색
	public Boast printOne(int boastNo);// 게시글 상세보기 
	public int registerBoast(Boast boast);// 게시글 등록
	public int modifyBoast(Boast boast);// 게시글 수정
	public int removeBoast(int boastNo);// 게시글 삭제 
	public ArrayList<Boast> printAllhashTagList(); // 해시태그 출력
	public int addReadCount(int boastNo); // 조회수 증가
	public ArrayList<BoastReply> printAllBoastReply(int boastNo); // 댓글 전체 출력
	public int registerBoastReply(BoastReply reply); // 댓글 등록
	public int modifyBoastReply(BoastReply reply); // 댓글 수정
	public int removeBoastReply(int boastNo); // 댓글 삭제
	public int likeNo(Boast boast); // 좋아요
	
	

}
