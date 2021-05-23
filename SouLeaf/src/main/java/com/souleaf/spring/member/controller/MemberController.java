package com.souleaf.spring.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.souleaf.spring.diary.domain.Guestbook;
import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService mService;
	
	// 회원가입 폼
	@RequestMapping(value="enrollView.kh", method=RequestMethod.GET)
	public String enrollView() {
		return "member/enrollView";
	}
//	// 회원등록
//	@RequestMapping(value="memberRegister.kh", method=RequestMethod.POST)
//	public String memberRegister(@ModelAttribute Member member,
//								 Model model) {
//		int result = mService.registerMember(member);
//		if(result < 0) {
//			return "redirect:home.kh";
//		}else {
//			model.addAttribute("msg", "회원 가입 실패!!");
//			return "common/errorPage";
//		}
//		
//	}
//	// 마이페이지 뷰
//	@RequestMapping(value="", method=RequestMethod.GET)
//	public String myPageView() {
//		return "member/myPage"; 
//	}
//	// 정보수정
//	@RequestMapping(value="memberModify.kh", method=RequestMethod.POST)
//	public String modifyMember(@ModelAttribute Member member,
//							   Model model, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		int result = mService.modifyMember(member);
//		if(result < 0 ){
//			session.setAttribute("loginMember", member);
//			return "redirect:home.kh";
//		}else {
//			model.addAttribute("msg", "정보 수정 실패" );
//			return "common/errorPage";
//		}
//		
//		
//	}
//	// 회원 탈퇴
//	@RequestMapping(value="", method=RequestMethod.GET)
//	public String memberDelete(
//							@RequestParam("memberId") String memberId,
//							Model model) {
//		int result = mService.deleteMember(memberId);
//		if(result > 0) {
//			return "redirect:logout.kh";
//		}else {
//			model.addAttribute("msg", "회원 탈퇴 실패");
//			return "common/errorPage";
//		}
//							
//		
//	}
    //아이디 중복 검사
//	@ResponseBody    
//	@RequestMapping(value="dupId.kh", method=RequestMethod.GET)
//	public String idDuplicateCheck(@RequestParam("memberId") String memberId) {
//		return String.valueOf(mService.checkIdDup(memberId));
//		
//	}
	
	// 회원 로그인 !!!!!!!!!!

	@RequestMapping(value="loginView.kh", method=RequestMethod.GET)
	public String memberLoginView(HttpServletRequest request) {
		return "login";
	}
	
	
	@RequestMapping(value="login.kh", method=RequestMethod.POST)
	public String memberLogin(HttpServletRequest request, @ModelAttribute Member member, Model model) {
		Member mOne = new Member(member.getMemberId(), member.getMemberPw());
		Member loginUser = mService.loginMember(mOne);
		if(loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			return "redirect:home.kh";
		}else {
			model.addAttribute("msg", "로그인 실패!");
			return "common/errorPage";
		}
	}
	
	// 로그아웃
	@RequestMapping(value="logout.kh", method=RequestMethod.GET)
	public String memberLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:home.kh";
	}
	
	//아이디 중복 검사
	@RequestMapping(value="idCheck.kh", method=RequestMethod.POST)
	public void idDupleCheck(HttpServletResponse response, @ModelAttribute Member member) throws JsonIOException, IOException {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); // 고정
		Integer result = 0; // 변수 값 
		result = mService.checkIdDup(member.getMemberId()) > 0 ? 1 : 0;
		gson.toJson(result, response.getWriter()); // 변수명 넣고 보내기
	}                                                      
}
	

