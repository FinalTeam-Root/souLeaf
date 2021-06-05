package com.souleaf.spring.qna.store;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.domain.QnaSearch;

@Repository
public class QnaStoreLogic implements QnaStore{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<Qna> selectAllList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit(); 
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("qnaMapper.selectQnaList", null, rowBounds);
	}
	
	@Override
	public ArrayList<Qna> selectSearchList(QnaSearch search) {
		return (ArrayList)sqlSession.selectList("qnaMapper.selectQnaList", search);
	}

	@Override
	public Qna selectOne(int qnaNo) {
		return sqlSession.selectOne("qnaMapper.selectOne", qnaNo);
	}

	@Override
	public int insertQna(Qna qna) {
		return sqlSession.insert("qnaMapper.insertQna", qna);
	}

	@Override
	public int updateQna(Qna qna) {
		return sqlSession.update("qnaMapper.updateQna", qna);
	}

	@Override
	public int deleteQna(int qnaNo) {
		return sqlSession.update("qnaMapper.deleteQna", qnaNo);
	}

	@Override
	public int selectListCount() {
		return sqlSession.selectOne("qnaMapper.selectListCount");
	}

	@Override
	public int addReadCount(int qnaNo) {
		return sqlSession.update("qnaMapper.updateCount", qnaNo);
	}

	@Override
	public ArrayList<Qna> selectAdminAll() {
		return (ArrayList)sqlSession.selectList("qnaMapper.selectAdminQnaList");
	}

	

}
