package com.souleaf.spring.plant.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantSearch;

public class PlantStoreLogic implements PlantStore{

	private SqlSession sqlSession;
	
	@Override
	public ArrayList<Plant> selectAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plant selectOne(Plant plant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCuriosity(Plant plant) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCuriosity(Plant plant) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCuriosity(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Plant> selectSearchAllList(PlantSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

}
