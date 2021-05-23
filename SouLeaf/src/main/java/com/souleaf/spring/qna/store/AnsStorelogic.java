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
	public Ans selectOne(int ansNo) {
		return sqlSession.selectOne("ansMapper.selectOne", ansNo);
	}

	@Override
	public int insertAns(Ans ans) {
		return sqlSession.insert("ansMapper.insertAns", ans);
	}

	@Override
	public int updateAns(Ans ans) {
		return sqlSession.update("ansMapper.updateAns");
	}

	@Override
	public int deleteAns(int ansNo) {
		return sqlSession.update("ansMapper.deleteAns", ansNo);
	}

	@Override
	public ArrayList<Ans> selectSearchList(AnsSearch search) {
		return (ArrayList)sqlSession.selectList("ansMapper.selectAnsList", search);
	}

	@Override
	public int selectListCount() {
		return sqlSession.selectOne("ansMapper.selectListCount");
	}

	@Override
	public int addReadCount(int ansNo) {
		return sqlSession.update("ansMapper.updateCount", ansNo);
	}

}
