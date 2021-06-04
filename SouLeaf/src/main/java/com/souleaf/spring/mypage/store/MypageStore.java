package com.souleaf.spring.mypage.store;

import java.util.ArrayList;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.curiosity.domain.Curiosity;

public interface MypageStore {
	
	public ArrayList<Boast> selectAllMyBoast(int memberNo);
	
	public ArrayList<Clinic> selectAllMyClinic(int memberNo);

	public ArrayList<Curiosity> selectAllMyCuriosity(int memberNo);


}
