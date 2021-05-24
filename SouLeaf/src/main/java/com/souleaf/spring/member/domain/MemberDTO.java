package com.souleaf.spring.member.domain;

import java.sql.Date;

public class MemberDTO {

    private String memberId;    //아이디
    private String memberPassword;    //비밀번호
    private String memberMail;    //이메일
    private Date memberJoin;    //가입일자
    
    
    
    public String getMemberId() {
        return memberId;
    }
    public void setMemberid(String memberId) {
        this.memberId = memberId;
    }
    public String getMemberPassword() {
        return memberPassword;
    }
    public void setMember_pass(String memberPassword) {
        this.memberPassword = memberPassword;
    }
    public String getMemberMail() {
        return memberMail;
    }
    public void setMemberEmail(String memberMail) {
        this.memberMail = memberMail;
    }
    public Date getMemberJoin() {
        return memberJoin;
    }
    public void setJoin_date(Date memberJoin) {
        this.memberJoin = memberJoin;
    }
    
    
    @Override
    public String toString() {
        return "MemberDTO [memberId=" + memberId + ", memberPassword=" + memberPassword + ", memberMail=" + memberMail + ", memberJoin="
                + memberJoin + "]";
    }
    
 
}

