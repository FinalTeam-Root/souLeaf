package com.souleaf.spring.diary.store;

import java.util.ArrayList;

import com.souleaf.spring.diary.domain.Diary;
import com.souleaf.spring.diary.domain.Guestbook;
import com.souleaf.spring.diary.domain.WaterDay;
import com.souleaf.spring.member.domain.Member;

public interface DiaryStore {

		//로그인한 사용자 회원 정보뿌려주기
		public Member printOneMember(int memberNo);
		
		// 일기 월별로 보기
		public ArrayList<Diary> monthViewListDiary(Diary diary);
		// 해당 날짜 클릭시 등록된 일기 보기
		public Diary selectOneDiary(Diary diary);
		// 마지막 물 준 날 유무
		public WaterDay selectOneWaterDay(WaterDay waterDay);
		// 마지막 물 준날 기준으로 물주는 날 표시
		public int insertWater(WaterDay waterDay);
		// 마지막 물 준날 기준으로 물주는 날 갱신 
		public int updateWater(WaterDay waterDay);
		// 일기 등록
		public int insertDiary(Diary diary);
		// 일기 수정
		public int updateDiary(Diary diary);
		// 일기 삭제
		public int deleteDiary(Diary diary);
		
		// 방명록 전체 조회
		public ArrayList<Guestbook> printAllGuestbook(int diaryNo);
		// 방명록 등록
		public int insertGuestbook(Guestbook guestbook);
		// 방명록 수정
		public int updateGuestbook(Guestbook guestbook);
		// 방명록 삭제
		public int deleteGuestbook(Guestbook guestbook);
		
		
		// 사진첩
		public ArrayList<Diary> selectPlantPicAll(int diaryNo);
		
		// 사진첩 동영상변환 @빽범
}
