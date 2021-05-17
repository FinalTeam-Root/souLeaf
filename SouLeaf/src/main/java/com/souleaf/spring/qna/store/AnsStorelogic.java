package com.souleaf.spring.qna.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.souleaf.spring.qna.domain.Ans;

public class AnsStorelogic implements AnsStore {
	private SqlSession sqlSession;

	@Override
	public ArrayList<Ans> selectAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ans selectOne(int aId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertAns(Ans ans) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAns(Ans ans) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAns(int aId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
