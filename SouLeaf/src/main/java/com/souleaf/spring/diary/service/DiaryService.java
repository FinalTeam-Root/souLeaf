package com.souleaf.spring.diary.service;

import java.util.ArrayList;

import com.souleaf.spring.diary.domain.Diary;
import com.souleaf.spring.diary.domain.Guestbook;
import com.souleaf.spring.diary.domain.WaterDay;

public interface DiaryService {
	
	// 일기 월별 리스트로 보기
	public ArrayList<Diary> monthViewListDiary(Diary diary);
	// 해당 날짜 클릭시 등록된 일기 보기
	public Diary printOneDiary(Diary diary);
	// 마지막 물 준 날 유무
	public WaterDay printOneWaterDay(WaterDay waterDay);
	// 마지막 물 준날 기준으로 물주는 날 표시
	public int registerWater(WaterDay waterDay);
	// 마지막 물 준날 기준으로 물주는 날 갱신 
	public int modifyWater(WaterDay waterDay);
	// 일기 등록
	public int registerDiary(Diary diary);
	// 일기 수정
	public int modifyDiary(Diary diary);
	// 일기 삭제
	public int removeDiary(Diary diary);
	
	// 방명록 전체 조회
	public ArrayList<Guestbook> printAllGuestbook(int diaryNo);
	// 방명록 등록
	public int registerGuestbook(Guestbook guestbook);
	// 방명록 수정
	public int modifyGuestbook(Guestbook guestbook);
	// 방명록 삭제
	public int removeGuestbook(Guestbook guestbook);
	
	
	// 사진첩 하단 
	public ArrayList<Diary> printPlantPicAll(int diaryNo);
	
	// 사진첩 동영상변환 @빽범
	
}
