package com.souleaf.spring.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.member.service.MemberService;
import com.souleaf.spring.member.store.MemberStore;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberStore mStore;

	@Override
	public List<Member> selectAll() {
		return mStore.selectAll();
	}

	@Override
	public Member loginMember(Member member) {
		
		return mStore.loginMember(member);
	}

	@Override
	public int checkIdDup(String memberId) {
		return mStore.checkIdDup(memberId);
	}

	@Override
	public int registerMember(Member member) {
		int result = mStore.insertMember(member);
		return result;
	}

	@Override
	public int modifyMember(Member member) {
		int result = mStore.updateMember(member);
		return result;
	}

	@Override
	public int deleteMember(String memberId) {
		return mStore.deleteMember(memberId);
	}

	@Override
	public int checkNick(String memberNick) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member printMember(int memberNo) {
		return mStore.selectMember(memberNo);
	}

}
