package com.souleaf.spring.plant.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantFile;
import com.souleaf.spring.plant.domain.PlantInfo;
import com.souleaf.spring.plant.domain.PlantSearch;
import com.souleaf.spring.plant.store.PlantStore;
@Service
public class PlantServiceImpl implements PlantService{
	@Autowired
	private PlantStore pStore;

	@Override
	public ArrayList<Plant> printAllList() {
		return pStore.selectAllList();
	}

	@Override
	public Plant printOne(Plant plant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerPlant(Plant plant, PlantInfo plantInfo, List<MultipartFile> fList, String filePath) {
		int result = 0;
		int basicResult = 0;
		int detailResult = 0;
		int fileResult = 1;
		
		basicResult = pStore.insertPlant(plant);
		detailResult = pStore.insertDetailPlant(plantInfo);
		int plantNo = pStore.selectOnePlant();
		for(MultipartFile mf : fList) {
			 String originalFilename = mf.getOriginalFilename(); //파일명		     
	         String fileFullPath = filePath+"/"+originalFilename; //파일 전체 경로
	         long fileSize = mf.getSize(); // 파일사이즈
	         try {
	                //파일 저장
	                PlantFile pFile = new PlantFile(originalFilename, fileFullPath, fileSize, plantNo);
	                fileResult *= pStore.insertPlantFile(pFile);
	                mf.transferTo(new File(fileFullPath)); //파일저장 실제로는 service에서 처리
	     
	            } catch (Exception e) {
	                System.out.println("postTempFile_ERROR======>"+fileFullPath);
	                e.printStackTrace();
	            }
		}
		result = basicResult * detailResult * fileResult;
		return result;
	}

	@Override
	public int modifyPlant(Plant plant) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removePlant(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Plant> printSearchAllList(PlantSearch search) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
