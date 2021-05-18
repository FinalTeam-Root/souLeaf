package com.souleaf.spring.qna.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.domain.QnaSearch;

@Repository
public class QnaStoreLogic implements QnaStore{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<Qna> selectAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Qna> selectSearchList(QnaSearch search) {
		return (ArrayList)sqlSession.selectList("qnaMapper.selectQnaList");
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
