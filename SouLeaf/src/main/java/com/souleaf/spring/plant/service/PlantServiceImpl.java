package com.souleaf.spring.plant.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantInfo;
import com.souleaf.spring.plant.domain.PlantSearch;
import com.souleaf.spring.plant.store.PlantStore;
@Service
public class PlantServiceImpl implements PlantService{
	@Autowired
	private PlantStore pStore;

	@Override
	public ArrayList<Plant> printAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plant printOne(Plant plant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerPlant(Plant plant, PlantInfo plantInfo) {
		int result = 0;
		int basicResult = 0;
		int detailResult = 0;
		basicResult = pStore.insertPlant(plant);
		detailResult = pStore.insertDetailPlant(plantInfo);
		result = basicResult * detailResult;
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
