package com.souleaf.spring.plant.service;

import java.util.ArrayList;

import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantSearch;
import com.souleaf.spring.plant.store.PlantStore;

public class PlantServiceImpl implements PlantService{
	
	private PlantStore factory;

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
	public int registerCuriosity(Plant plant) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCuriosity(Plant plant) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCuriosity(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Plant> printSearchAllList(PlantSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

}
