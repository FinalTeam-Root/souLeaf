package com.souleaf.spring.diary.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.diary.domain.Diary;
import com.souleaf.spring.diary.domain.Guestbook;
import com.souleaf.spring.diary.domain.WaterDay;

@Repository
public class DiaryStoreLogic implements DiaryStore{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<Diary> monthViewListDiary(Diary diary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diary selectOneDiary(Diary diary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WaterDay selectOneWaterDay(WaterDay waterDay) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertWater(WaterDay waterDay) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateWater(WaterDay waterDay) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertDiary(Diary diary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDiary(Diary diary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDiary(Diary diary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Guestbook> printAllGuestbook(int diaryNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertGuestbook(Guestbook guestbook) {
		return sqlSession.insert("diaryMapper.insertGuestbook",guestbook);
	}

	@Override
	public int updateGuestbook(Guestbook guestbook) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteGuestbook(Guestbook guestbook) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Diary> selectPlantPicAll(int diaryNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
