package com.souleaf.spring.qna.store;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.qna.domain.Ans;
import com.souleaf.spring.qna.domain.AnsSearch;

public class AnsStorelogic implements AnsStore {
	private SqlSession sqlSession;

	@Override
	public ArrayList<Ans> selectAllList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("ansMapper.selectAnsList", null, rowBounds);
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

	@Override
	public ArrayList<Ans> selectSearchList(AnsSearch search) {
		return (ArrayList)sqlSession.selectList("ansMapper.selectAnsList", search);
	}

}
