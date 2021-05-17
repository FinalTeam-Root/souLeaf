package com.souleaf.spring.qna.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.domain.QnaSearch;

public class QnaStoreLogic implements QnaStore{
	private SqlSession sqlSession;

	@Override
	public ArrayList<Qna> selectAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Qna> selectSearchList(QnaSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Qna selectOne(int qId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertQna(Qna qna) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateQna(Qna qna) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteQna(int qId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
