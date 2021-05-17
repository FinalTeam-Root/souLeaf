package com.souleaf.spring.boast.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastReply;
import com.souleaf.spring.boast.domain.BoastSearch;

import com.souleaf.spring.boast.store.BoastStore;

//@Service
public class BoastServiceImpl implements BoastService {
	
//	@Autowired
	private BoastStore bStore;

	@Override
	public ArrayList<Boast> printAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Boast> printSearchAll(BoastSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boast printOne(int boastNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerBoast(Boast boast) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyBoast(Boast boast) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeBoast(int boastNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Boast> printAllhashTagList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addReadCount(int boastNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<BoastReply> printAllBoastReply(int boastNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerBoastReply(BoastReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyBoastReply(BoastReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeBoastReply(int boastNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int likeNo(Boast boast) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 게시판 NO 취득
	 * @author ohwoocheol
	 * @since 2021.8.16
	 */
	@Override
	public ArrayList<Boast> printAllNo() {
		// TODO Auto-generated method stub
		return bStore.selectAllNo();
	}
	/**
	 * 좋아요 포인트 초기화
	 * @author ohwoocheol
	 * @since 2021.8.15
	 */
	@Override
	public int pointReset(int boastNo) {
		// TODO Auto-generated method stub
		return bStore.updatePoint(boastNo);
	}
	/**
	 * 3위 까지 출력
	 * @author ohwoocheol
	 * @param boastNo 
	 * @since 2021.8.15
	 */
	@Override
	public ArrayList<Boast> printRank() {
		// TODO Auto-generated method stub
		return bStore.selectRank();
	}



}
