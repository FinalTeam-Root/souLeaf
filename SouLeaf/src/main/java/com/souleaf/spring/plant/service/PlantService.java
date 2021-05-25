package com.souleaf.spring.plant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantFile;
import com.souleaf.spring.plant.domain.PlantInfo;
import com.souleaf.spring.plant.domain.PlantSearch;


public interface PlantService {

	public ArrayList<Plant> printAllList();// 식물도감 리스트 출력
	public Plant printOne(int plantNo);// 식물도감 기본정보 출력
	public PlantInfo printOneInfo(int plantNo);// 식물도감 상세정보 출력
	public ArrayList<PlantFile> printFileList(int plantNo); // 식물도감 이미지 리스트 출력
	public int registerPlant(Plant plant,PlantInfo plantInfo, List<MultipartFile> fList, String filePath);// 식물도감 등록
	public int modifyPlant(Plant plant,PlantInfo plantInfo, List<MultipartFile> fList, String filePath);// 식물도감 수정
	public int removePlant(int plantNo);// 식물도감 삭제
	public ArrayList<Plant> printSearchAllList(PlantSearch search);//식물도감 검색
}
