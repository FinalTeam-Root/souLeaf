package com.souleaf.spring.mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.souleaf.spring.boast.service.BoastService;
import com.souleaf.spring.clinic.service.ClinicService;
import com.souleaf.spring.curiosity.service.CuriosityService;

@Controller
public class MypageController {
	
//	@Autowired
//	private BoastService bService;
//	
//	@Autowired
//	private ClinicService cService;
//	
//	@Autowired
//	private CuriosityService curService;
	
	// 마이페이지 뷰
	@RequestMapping(value = "mypage.kh", method = RequestMethod.GET)
	public String myPageView() {
		return "mypage/myPage";
	}
	
	@RequestMapping(value="mypageBoard.kh")
	public String mypageBoard() {
		return "mypage/mypageBoard";
	}
}
