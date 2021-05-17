package com.souleaf.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.member.service.MemberService;

//@Controller
public class MemberController {
//	@Autowired
//	private MemberService service;
	private MemberService mService;
	
	// 회원가입 폼
	@RequestMapping(value="enrollView.kh", method=RequestMethod.GET)
	public String enrollView() {
		return "member/memberJoin";
	}
	// 회원등록
	@RequestMapping(value="memberRegister.kh", method=RequestMethod.POST)
	public String memberRegister(@ModelAttribute Member member,
								 @RequestParam("post") String post , Model model) {
		int result = mService.registerMember(member);
		if(result < 0) {
			return "redirect:home.kh";
		}else {
			model.addAttribute("msg", "회원 가입 실패!!");
			return "common/errorPage";
		}
		
	}
	// 마이페이지 뷰
	@RequestMapping(value="", method=RequestMethod.GET)
	public String myInfoView() {
		return ""; 
	}
	// 정보수정
	@RequestMapping(value="memberModify.kh", method=RequestMethod.POST)
	public String modifyMember(@ModelAttribute Member member,
							   @RequestParam("post") String post, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int result = mService.modifyMember(member);
		if(result < 0 ){
			session.setAttribute("loginMember", member);
			return "redirect:home.kh";
		}
		return null;
		
	}
	// 회원 탈퇴
	@RequestMapping(value="", method=RequestMethod.GET)
	public String memberDelete(
							@RequestParam("memberId") String memberId,
							Model model) {
								return memberId;
		
	}
	// 아이디 중복 검사
	@ResponseBody    
	@RequestMapping(value="dupId.kh", method=RequestMethod.GET)
	public String idDuplicateCheck(@RequestParam("memberId") String memberId) {
		return memberId;
		
	}
	
	// 회원 로그인 !!!!!!!!!!
	
	@RequestMapping(value="login.kh", method=RequestMethod.POST)
	public String memberLogin(HttpServletRequest request) {
		return "home";
	}
	
	
}
	

