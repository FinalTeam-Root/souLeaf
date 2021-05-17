package com.souleaf.spring.plant.store;

import java.util.ArrayList;

import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantSearch;

public interface PlantStore {
	public ArrayList<Plant> selectAllList();// 식물도감 리스트 출력
	public Plant selectOne(Plant plant);// 식물도감 상세보기
	public int insertCuriosity(Plant plant);// 식물도감 등록
	public int updateCuriosity(Plant plant);// 식물도감 수정
	public int deleteCuriosity(int curiosityNo);// 식물도감 삭제
	public ArrayList<Plant> selectSearchAllList(PlantSearch search);//식물도감 검색
}
