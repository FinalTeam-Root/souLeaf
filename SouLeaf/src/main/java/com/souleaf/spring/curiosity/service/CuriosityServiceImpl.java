package com.souleaf.spring.curiosity.service;

import java.util.ArrayList;

import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.domain.CuriosityReply;
import com.souleaf.spring.curiosity.domain.CuriositySearch;
import com.souleaf.spring.curiosity.store.CuriosityStore;
import com.souleaf.spring.plant.domain.Plant;

public class CuriosityServiceImpl implements CuriosityService {

	private CuriosityStore factory;

	@Override
	public ArrayList<Curiosity> printAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curiosity printOne(Curiosity curiosity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerCuriosity(Curiosity curiosity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCuriosity(Curiosity curiosity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCuriosity(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Curiosity> printSearchAllList(CuriositySearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Plant> printAllhashTagList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addReadCount(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CuriosityReply> printAllCuriosityReply(int curiosityNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerCuriosityReply(CuriosityReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCuriosityReply(CuriosityReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCuriosityReply(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
