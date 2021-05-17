package com.souleaf.spring.boast.store;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastSearch;

//@Repository
public class BoastStoreLogic implements BoastStore {

//	@Autowired
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
