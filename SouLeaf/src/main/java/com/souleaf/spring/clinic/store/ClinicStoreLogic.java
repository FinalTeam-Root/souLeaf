package com.souleaf.spring.clinic.store;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.domain.ClinicCommnet;
import com.souleaf.spring.common.PageInfo;

//@Repository
public class ClinicStoreLogic implements ClinicStore{
	
//	@Autowired
	private SqlSession sqlSession;

	@Override
	public int selectListCount() {
		return sqlSession.selectOne("clinicMapper.selectListCount");
	}

	@Override
	public ArrayList<Clinic> selectAllList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("clinicMapper.selectAllList", null, rowBounds);
	}

	@Override
	public int addReadCount(int clinicNo) {
		return sqlSession.update("clinicMapper.updateCount", clinicNo);
	}

	@Override
	public Clinic selectOne(int clinicNo) {
		return sqlSession.selectOne("boardMapper.selectOne", clinicNo);
	}

	@Override
	public int insertBoard(Clinic clinic) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(Clinic clinic) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int clinicNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ClinicCommnet> selectAllReply(int clinicNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertReply(ClinicCommnet clinicCommnet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReply(ClinicCommnet clinicCommnet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReply(ClinicCommnet clinicCommnet) {
		// TODO Auto-generated method stub
		return 0;
	}

}
