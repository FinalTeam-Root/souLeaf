package com.souleaf.spring.clinic.store;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.clinic.domain.Clinic;
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
		return sqlSession.selectOne("curiosityMapper.selectListCount");
	}
	
	@Override
	public ArrayList<Clinic> selectAllList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit(); 
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("curiosityMapper.selectAllList", null, rowBounds);
	}

	@Override
	public Clinic selectOne(int curiosityNo) {
		return sqlSession.selectOne("curiosityMapper.selectClinic",curiosityNo);
	}

	@Override
	public int insertClinic(Clinic curiosity) {
		return sqlSession.insert("curiosityMapper.insertClinic", curiosity);
	}

	@Override
	public int updateClinic(Clinic curiosity) {
		// TODO Auto-generated method stub
		return sqlSession.update("curiosityMapper.updateClinic", curiosity);
	}

	@Override
	public int deleteClinic(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
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
	public int addReadCount(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ClinicReply> selectAllClinicReply(int curiosityNo) {
		return (ArrayList)sqlSession.selectList("curiosityMapper.selectAllReplyList",curiosityNo);
	}

	@Override
	public int insertClinicReply(ClinicReply reply) {
		// TODO Auto-generated method stub
		return sqlSession.insert("curiosityMapper.insertReply", reply);
	}

	@Override
	public int updateClinicReply(ClinicReply reply) {
		return sqlSession.update("curiosityMapper.updateReply", reply);
	}

	@Override
	public int deleteClinicReply(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateViewCount(int curiosityNo) {
		sqlSession.update("curiosityMapper.updateViewCount",curiosityNo);
		
	}



}
