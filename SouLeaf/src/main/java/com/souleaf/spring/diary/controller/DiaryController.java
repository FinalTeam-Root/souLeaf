package com.souleaf.spring.diary.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.souleaf.spring.diary.domain.Diary;
import com.souleaf.spring.diary.domain.Guestbook;
import com.souleaf.spring.diary.domain.WaterDay;
import com.souleaf.spring.diary.service.DiaryService;
import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.member.service.MemberService;

@Controller
public class DiaryController {
	
	@Autowired
	private DiaryService dService;
	
	// 상단의 성장일기 클릭시 화면 이동
	@RequestMapping(value="diaryMainView.kh")
	public String diaryView() {
		return "diary/diaryMain";
	}
	
	// 일기 월별 리스트로 보기
	public String diaryList() {
		return null;
	}
	// 해당 날짜 클릭시 등록된 일기 보기
	public String diaryDetailView() {	
		return null;
	}
	// 일기 등록 화면
	public String diaryWriteView() {
		return null;
	};
	// 일기 등록하기
	public String registerDiary() {
		// if 일기 등록 성공
		// 	if waterday테이블이 null이면 
		// 	insert registerWater()
		// 	else 
		// 	update modifyWater()
		//  
		return null;
	};
	// 파일 저장하기
	public String saveFile() {
		return null;
	}
	// 일기 수정 화면
	public String diaryModifyView() {
		return null;
	};
	// 일기 수정하기
	public String diaryUpdate() {
		return null;
	}
	// 일기 삭제하기
	public String diaryDelete() {
		return null;
	}
	// 저장된 파일 삭제
	public void deleteFile() {}
	
	// 방명록 전체 조회
	public String guestbookList() {
		return null;
	}
	// 방명록 등록
	@ResponseBody
	@RequestMapping(value="regiseterGuestbook.kh", method=RequestMethod.POST)
	public String registerGuestbook(@ModelAttribute Guestbook guestbook, HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		guestbook.setMemberNo(loginUser.getMemberNo());
		int result = dService.registerGuestbook(guestbook);
		if(result > 0) {
			return "success";
		} else {
			return "fail";			
		}
	}
	// 방명록 수정
	public String guestbookUpdate() {
		return null;
	}
	// 방명록 삭제
	public String guestbookDelete() {
		return null;
	}
	
	// 사진첩 하단
	public String diaryPicList() {
		return null;
	}
	// 사진 동영상 변환...@빽범
}
