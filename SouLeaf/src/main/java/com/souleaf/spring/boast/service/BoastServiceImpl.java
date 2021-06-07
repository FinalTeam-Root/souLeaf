package com.souleaf.spring.boast.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.souleaf.spring.boast.domain.BoFile;
import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastReply;
import com.souleaf.spring.boast.domain.BoastSearch;

import com.souleaf.spring.boast.store.BoastStore;
import com.souleaf.spring.common.PageInfo;


@Service
public class BoastServiceImpl implements BoastService {
	
@Autowired
	private BoastStore bStore;

@Override
	public ArrayList<Boast> printAll(PageInfo pi) {
		//
		return bStore.selectAllList(pi);
	}

	@Override
	public ArrayList<Boast> printSearchAll(BoastSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boast printOne(int boastNo) {
		//
		return bStore.selectOne(boastNo);
	}
	
	@Override
	public int getListCount() {
		//
		return bStore.selectListCount();
	}
	

	
	

	@Override
	public int registerBoast(Boast boast) {
		//
		return bStore.insertBoast(boast);
	}

	@Override
	public int modifyBoast(Boast boast) {
		//
		return bStore.updateBoast(boast);
	}

	@Override
	public int removeBoast(int boastNo) {
		//
		return bStore.deleteBoast(boastNo);
	}

	@Override
	public ArrayList<Boast> printAllhashTagList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addReadCount(int boastNo) {
		//
		return bStore.addReadCount(boastNo);
	}

	@Override
	public ArrayList<BoastReply> printAllBoastReply(int boastNo) {
		//
		return bStore.selectAllBoastReply(boastNo);
	}

	@Override
	public int registerBoastReply(BoastReply reply) {
		//
		return bStore.insertBoastReply(reply);
	}

	@Override
	public int modifyBoastReply(BoastReply reply) {
		// 
		return bStore.updateBoastReply(reply);
	}

	@Override
	public int removeBoastReply(BoastReply reply) {
		// 
		return bStore.deleteBoastReply(reply);
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


	@Override
	public ArrayList<Boast> printAll() {
		return bStore.selectAll();
	}

	@Override
	public int removeAdminBoast(HashMap<String, String> map) {
		return bStore.deleteAdminBoast(map);
	}

	

	@Override
	public int removeFile(BoFile boFile) {
		// TODO Auto-generated method stub
		return 0;
	}
}
