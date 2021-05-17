package com.souleaf.spring.boast.service;

import java.util.ArrayList;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastReply;
import com.souleaf.spring.boast.domain.BoastSearch;

import com.souleaf.spring.boast.store.BoastStore;

public class BoastServiceImpl implements BoastService {

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


	

}
