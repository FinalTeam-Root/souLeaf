package com.souleaf.spring.admin.store;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.admin.domain.MemberStatus;
@Repository
public class AdminStoreLogic implements AdminStore {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberStatus selectMemberStatus() {
		return sqlSession.selectOne("adminMapper.selectMemberStatus");
	}

	@Override
	public int updateMemberStatus(HashMap<String, String> map) {
		return sqlSession.update("adminMapper.updateMemberStatus", map);
	}
}
