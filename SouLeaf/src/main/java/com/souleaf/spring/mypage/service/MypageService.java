package com.souleaf.spring.mypage.service;

import java.util.ArrayList;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.curiosity.domain.Curiosity;

public interface MypageService {	
	
	public ArrayList<Boast> printAllMyBoast(int memberNo);
	
	public ArrayList<Clinic> printAllMyClinic(int memberNo);
	
	public ArrayList<Curiosity> printAllMyCuriosity(int memberNo);


}
