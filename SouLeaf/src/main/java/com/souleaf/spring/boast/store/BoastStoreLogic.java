package com.souleaf.spring.boast.store;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastSearch;


public class BoastStoreLogic implements BoastStore {

	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public ArrayList<Boast> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Boast> selectSearchList(BoastSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boast selectOne(int boastNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBoast(Boast boast) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoast(Boast boast) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoast(int boastNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	


}
