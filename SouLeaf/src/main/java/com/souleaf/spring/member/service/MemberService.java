package com.souleaf.spring.member.service;

import java.util.List;

import com.souleaf.spring.member.domain.Member;

public interface MemberService {
	public List<Member> selectAll(); // 멤버전체출력
	public Member loginMember(Member member); // 로그인
	public int checkIdDup(String memberId);
	public int checkNick(String memberNick);
	public int registerMember(Member member);
	public int modifyMember(Member member);
	public int deleteMember(String memberId);
	
}

