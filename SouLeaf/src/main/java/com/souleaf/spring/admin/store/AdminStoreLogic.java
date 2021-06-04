package com.souleaf.spring.admin.store;

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
		// TODO Auto-generated method stub
		return sqlSession.selectOne("adminMapper.selectMemberStatus");
	}
}
