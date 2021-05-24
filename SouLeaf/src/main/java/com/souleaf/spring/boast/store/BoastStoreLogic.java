package com.souleaf.spring.boast.store;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastReply;
import com.souleaf.spring.boast.service.BoastService;
import com.souleaf.spring.boast.domain.BoastSearch;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.plant.domain.Plant;

@Repository
public class BoastStoreLogic implements BoastStore {

@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int selectListCount() {
		//
		return sqlSession.selectOne("boastMapper.selectListCount");
	}

	@Override
	public ArrayList<Boast> selectAllList(PageInfo pi) {
		
		int offset = (pi.getCurrentPage() - 1) * pi.getPageLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getPageLimit());
		return (ArrayList)sqlSession.selectList("boastMapper.selectAllList", null, rowBounds);
	}
	
//	@Override
//	public ArrayList<Boast> selectAllList(PageInfo pi) {//
//		int offset = (pi.getCurrentPage() - 1) * pi.getPageLimit();
//		RowBounds rowBounds = new RowBounds(offset, pi.getPageLimit());
//		return (ArrayList)sqlSession.selectList("boastMapper.selectAllList", null, rowBounds);
//	}
	
//	@Override
//	public ArrayList<Boast> selectAllList() {
//		return (ArrayList)sqlSession.selectList("boastMapper.selectAll");
//	}

	
	@Override
	public ArrayList<Boast> selectSearchList(BoastSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boast selectOne(int boastNo) {
		// 
		return sqlSession.selectOne("boastMapper.selectOne", boastNo);
	}

	@Override
	public int addReadCount(int boastNo) {
		// 
		return sqlSession.update("boastMapper.updateCount", boastNo);
	}
	
	@Override
	public int insertBoast(Boast boast) {
		// 
		return sqlSession.insert("boastMapper.insertBoast", boast);
	}

	@Override
	public int updateBoast(Boast boast) {
		// 
		return sqlSession.update("boastMapper.updateBoast", boast);
	}

	@Override
	public int deleteBoast(int boastNo) {
		// 
		return sqlSession.update("bastMapper.deleteBoast", boastNo);
	}
	
	@Override
	public ArrayList<BoastReply> selectAllBoastReply(int boastNo) {
		// 
		return (ArrayList)sqlSession.selectList("boastMapper.selectBoastReply",boastNo);
	}
	
	@Override
	public int insertBoastReply(BoastReply reply) {
		// 
		return sqlSession.insert("boastMapper.insertBoastReply", reply);
	}
	
	@Override
	public int updateBoastReply(BoastReply reply) {
		// 
		return sqlSession.update("boastMapper.updateReply", reply);
	}
	
	@Override
	public int deleteBoastReply(BoastReply reply) {
		// 
		return sqlSession.delete("boastMapper.deleteBoastReply", reply);
	}
	
	
	
	
	
	
	/**
	 * 좋아요 포인트 초기화
	 * @author ohwoocheol
	 * @since 2021.8.15
	 */
	@Override
	public ArrayList<Boast> selectAllNo() {
		return (ArrayList)sqlSession.selectList("boastMapper.selectAllNo");
	}
	/**
	 * 게시판 NO 취득
	 * @author ohwoocheol
	 * @since 2021.8.16
	 */
	@Override
	public int updatePoint(int boastNo) {
		return sqlSession.update("boastMapper.updatePoint", boastNo);
	}
	/**
	 * 3위 까지 출력
	 * @author ohwoocheol
	 * @param boastNo 
	 * @since 2021.8.15
	 */
	@Override
	public ArrayList<Boast> selectRank() {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("boastMapper.selectRank");
	}


	



}
