package com.souleaf.spring.clinic.store;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.domain.ClinicLike;
import com.souleaf.spring.clinic.domain.ClinicReply;
import com.souleaf.spring.clinic.domain.ClinicSearch;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.plant.domain.Plant;


@Repository
public class ClinicStoreLogic implements ClinicStore{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int selectClinicListCount() {
		return sqlSession.selectOne("clinicMapper.selectListCount");
	}
	
	@Override
	public ArrayList<Clinic> selectAllList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit(); 
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("clinicMapper.selectAllList", null, rowBounds);
	}

	@Override
	public Clinic selectOne(int clinicNo) {
		return sqlSession.selectOne("clinicMapper.selectClinic",clinicNo);
	}

	@Override
	public int insertClinic(Clinic clinic) {
		return sqlSession.insert("clinicMapper.insertClinic", clinic);
	}

	@Override
	public int updateClinic(Clinic clinic) {
		// TODO Auto-generated method stub
		return sqlSession.update("clinicMapper.updateClinic", clinic);
	}

	@Override
	public int deleteClinic(int clinicNo) {
		// TODO Auto-generated method stub
		return sqlSession.update("clinicMapper.deleteClinic", clinicNo);
	}

	@Override
	public ArrayList<Clinic> selectSearchAllList(ClinicSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Plant> selectAllhashTagList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addReadCount(int clinicNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ClinicReply> selectAllClinicReply(int clinicNo) {
		return (ArrayList)sqlSession.selectList("clinicMapper.selectAllReplyList",clinicNo);
	}

	@Override
	public int insertClinicReply(ClinicReply reply) {
		// TODO Auto-generated method stub
		return sqlSession.insert("clinicMapper.insertReply", reply);
	}

	@Override
	public int updateClinicReply(ClinicReply reply) {
		return sqlSession.update("clinicMapper.updateReply", reply);
	}

	@Override
	public int deleteClinicReply(int clinicNo) {
		return sqlSession.update("clinicMapper.deleteReply", clinicNo);
	}

	@Override
	public void updateViewCount(int clinicNo) {
		sqlSession.update("clinicMapper.updateViewCount",clinicNo);
		
	}

	// 좋아요 확인
	@Override
	public ClinicLike selectLike(ClinicLike clinicLike) {
		return sqlSession.selectOne("clinicMapper.selectlike", clinicLike);
	}



}
