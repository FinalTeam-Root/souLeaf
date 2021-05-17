package com.souleaf.spring.curiosity.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.domain.CuriosityReply;
import com.souleaf.spring.curiosity.domain.CuriositySearch;
import com.souleaf.spring.plant.domain.Plant;

public class CuriosityStoreLogic implements CuriosityStore{
	
	private SqlSession sqlSession;

	@Override
	public ArrayList<Curiosity> selectAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curiosity selectOne(Curiosity curiosity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCuriosity(Curiosity curiosity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCuriosity(Curiosity curiosity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCuriosity(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Curiosity> selectSearchAllList(CuriositySearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Plant> selectAllhashTagList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addReadCount(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CuriosityReply> selectAllCuriosityReply(int curiosityNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCuriosityReply(CuriosityReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCuriosityReply(CuriosityReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCuriosityReply(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
