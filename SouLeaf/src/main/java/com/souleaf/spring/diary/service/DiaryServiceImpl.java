package com.souleaf.spring.diary.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.diary.domain.Diary;
import com.souleaf.spring.diary.domain.Guestbook;
import com.souleaf.spring.diary.domain.WaterDay;
import com.souleaf.spring.diary.store.DiaryStore;

@Service
public class DiaryServiceImpl implements DiaryService{

	@Autowired
	private DiaryStore dStore;
	
	@Override
	public ArrayList<Diary> monthViewListDiary(Diary diary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diary printOneDiary(Diary diary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WaterDay printOneWaterDay(WaterDay waterDay) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerWater(WaterDay waterDay) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyWater(WaterDay waterDay) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int registerDiary(Diary diary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyDiary(Diary diary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeDiary(Diary diary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Guestbook> printAllGuestbook(int diaryNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerGuestbook(Guestbook guestbook) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyGuestbook(Guestbook guestbook) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeGuestbook(Guestbook guestbook) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Diary> printPlantPicAll(int diaryNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
