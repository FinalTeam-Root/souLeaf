package com.souleaf.spring.member.service;

import java.util.List;

import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.member.service.MemberService;
import com.souleaf.spring.member.store.MemberStore;

public class MemberServiceImpl implements MemberService {
	private MemberStore factory;

	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member loginMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkIdDup(String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int registerMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkNick(String memberNick) {
		// TODO Auto-generated method stub
		return 0;
	}

}
