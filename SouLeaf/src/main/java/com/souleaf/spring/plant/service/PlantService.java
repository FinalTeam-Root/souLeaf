package com.souleaf.spring.plant.service;

import java.util.ArrayList;

import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantSearch;


public interface PlantService {

	public ArrayList<Plant> printAllList();// 식물도감 리스트 출력
	public Plant printOne(Plant plant);// 식물도감 상세보기
	public int registerCuriosity(Plant plant);// 식물도감 등록
	public int modifyCuriosity(Plant plant);// 식물도감 수정
	public int removeCuriosity(int curiosityNo);// 식물도감 삭제
	public ArrayList<Plant> printSearchAllList(PlantSearch search);//식물도감 검색
}
