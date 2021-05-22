package com.souleaf.spring.plant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantInfo;
import com.souleaf.spring.plant.domain.PlantSearch;


public interface PlantService {

	public ArrayList<Plant> printAllList();// 식물도감 리스트 출력
	public Plant printOne(Plant plant);// 식물도감 상세보기
	public int registerPlant(Plant plant,PlantInfo plantInfo, List<MultipartFile> fList, String filePath);// 식물도감 등록
	public int modifyPlant(Plant plant);// 식물도감 수정
	public int removePlant(int curiosityNo);// 식물도감 삭제
	public ArrayList<Plant> printSearchAllList(PlantSearch search);//식물도감 검색
}
