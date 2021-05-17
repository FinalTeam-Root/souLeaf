package com.souleaf.spring.member.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.member.store.MemberStore;

public class MemberStoreLogic implements MemberStore {
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectOneMember(Member member) {
		Member loginMember = sqlSession.selectOne("memberMapper.selectOneMember", member);
		return loginMember;
	}

	@Override
	public int checkIdDup(String memberId) {
		return sqlSession.selectOne("memberMapper.checkIdDup", memberId);
	}

	@Override
	public int insertMember(Member member) {
		int result = sqlSession.insert("memberMapper.insertMember", member);
		return result;
	}

	@Override
	public int updateMember(Member member) {
		int result = sqlSession.update("memberMapper.updateMember", member);
		return result;
	}

	@Override
	public int deleteMember(String memberId) {
		return sqlSession.delete("memberMapper.deleteMember", memberId);
	}

	@Override
	public Member loginMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}


}
