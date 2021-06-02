package com.souleaf.spring.admin.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AdminStoreLogic implements AdminStore {
	@Autowired
	private SqlSession sqlSession;
}
