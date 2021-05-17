package com.souleaf.spring.diary.controller;

import com.souleaf.spring.diary.domain.Diary;
import com.souleaf.spring.diary.domain.WaterDay;

public class DiaryController {
	
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
	public String registerGuestbook() {
		return null;
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
