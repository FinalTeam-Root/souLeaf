package com.souleaf.spring.plant.store;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantFile;
import com.souleaf.spring.plant.domain.PlantInfo;
import com.souleaf.spring.plant.domain.PlantSearch;
@Repository
public class PlantStoreLogic implements PlantStore{
	@Autowired
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
	public int insertPlant(Plant plant) {
		return sqlSession.insert("plantMapper.insertPlant", plant);
	}

	@Override
	public int insertDetailPlant(PlantInfo plantInfo) {
		return sqlSession.insert("plantMapper.insertPlantDetail", plantInfo);
	}

	@Override
	public int updatePlant(Plant plant) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePlant(int curiosityNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Plant> selectSearchAllList(PlantSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectOnePlant() {
		return sqlSession.selectOne("plantMapper.plantNo");
	}

	@Override
	public int insertPlantFile(PlantFile pFile) {
		
		return sqlSession.insert("plantMapper.insertPlantFile",pFile);
	}

	
	


}
