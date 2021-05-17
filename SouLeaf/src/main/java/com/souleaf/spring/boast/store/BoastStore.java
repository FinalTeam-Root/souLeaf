package com.souleaf.spring.boast.store;

import java.util.ArrayList;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastSearch;


public interface BoastStore {

	public ArrayList<Boast> selectList(); 
	public ArrayList<Boast> selectSearchList(BoastSearch search);
	public Boast selectOne(int boastNo); 
	public int insertBoast(Boast boast);
	public int updateBoast(Boast boast);
	public int deleteBoast(int boastNo); 
}
