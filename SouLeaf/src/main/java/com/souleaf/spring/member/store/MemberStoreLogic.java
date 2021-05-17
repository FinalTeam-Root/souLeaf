package com.souleaf.spring.member.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.member.store.MemberStore;

public class MemberStoreLogic implements MemberStore {
	private SqlSession sqlSession;

	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectOneMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkIdDup(String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member loginMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}


}
