package com.souleaf.spring.member.store;

import java.util.List;

import com.souleaf.spring.member.domain.Member;

public interface MemberStore {
	public List<Member> selectAll(); // 멤버전체출력
	public Member selectOneMember(Member member);
	public int checkIdDup(String memberId);
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(String memberId);
	public Member loginMember(Member member); // 로그인
}
