package com.souleaf.spring.mypage.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.mypage.store.MypageStore;

@Service
public class MypageServiceImpl implements MypageService{

	
	@Autowired
	private MypageStore mStore;
	
	@Override
	public ArrayList<Boast> printAllMyBoast(int memberNo) {
		return mStore.selectAllMyBoast(memberNo);
	}

	@Override
	public ArrayList<Clinic> printAllMyClinic(int memberNo) {
		return mStore.selectAllMyClinic(memberNo);
	}

	@Override
	public ArrayList<Curiosity> printAllMyCuriosity(int memberNo) {
		return mStore.selectAllMyCuriosity(memberNo);
	}

}
