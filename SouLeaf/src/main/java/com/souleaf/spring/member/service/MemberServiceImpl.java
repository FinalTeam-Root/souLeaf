package com.souleaf.spring.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.member.service.MemberService;
import com.souleaf.spring.member.store.MemberStore;
@Service
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
		return factory.checkIdDup(memberId);
	}

	@Override
	public int registerMember(Member member) {
		int result = factory.insertMember(member);
		return result;
	}

	@Override
	public int modifyMember(Member member) {
		int result = factory.updateMember(member);
		return result;
	}

	@Override
	public int deleteMember(String memberId) {
		return factory.deleteMember(memberId);
	}

	@Override
	public int checkNick(String memberNick) {
		// TODO Auto-generated method stub
		return 0;
	}

}
