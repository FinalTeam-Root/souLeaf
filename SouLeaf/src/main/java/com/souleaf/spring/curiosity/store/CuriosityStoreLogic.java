package com.souleaf.spring.curiosity.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.domain.CuriosityReply;
import com.souleaf.spring.curiosity.domain.CuriositySearch;
import com.souleaf.spring.plant.domain.Plant;
@Repository
public class CuriosityStoreLogic implements CuriosityStore{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<Curiosity> selectAllList() {
		return (ArrayList)sqlSession.selectList("curiosityMapper.selectAllList");
	}

	@Override
	public Curiosity selectOne(int curiosityNo) {
		return sqlSession.selectOne("curiosityMapper.selectCuriosity",curiosityNo);
	}

	@Override
	public int insertCuriosity(Curiosity curiosity) {
		return sqlSession.insert("curiosityMapper.insertCuriosity", curiosity);
	}

	@Override
	public int updateCuriosity(Curiosity curiosity) {
		// TODO Auto-generated method stub
		return sqlSession.update("curiosityMapper.updateCuriosity", curiosity);
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
		return (ArrayList)sqlSession.selectList("curiosityMapper.selectAllReplyList",curiosityNo);
	}

	@Override
	public int insertCuriosityReply(CuriosityReply reply) {
		// TODO Auto-generated method stub
		return sqlSession.insert("curiosityMapper.insertReply", reply);
	}

	@Override
	public int updateCuriosityReply(CuriosityReply reply) {
		return sqlSession.update("curiosityMapper.updateReply", reply);
	}

	@Override
	public int deleteCuriosityReply(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
