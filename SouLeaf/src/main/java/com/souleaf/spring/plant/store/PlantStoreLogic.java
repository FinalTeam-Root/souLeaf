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
		return (ArrayList)sqlSession.selectList("plantMapper.selectAll");
	}

	@Override
	public Plant selectOne(int plantNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("plantMapper.selectPlant", plantNo);
	}
	
	@Override
	public PlantInfo selectOneInfo(int plantNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("plantMapper.selectPlantInfo",plantNo);
	}

	@Override
	public ArrayList<PlantFile> selectFileList(int plantNo) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("plantMapper.selectFileList",plantNo);
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
		return sqlSession.update("plantMapper.updatePlant",plant);
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

	@Override
	public int updateDetailPlant(PlantInfo plantInfo) {
		return sqlSession.update("plantMapper.updatePlantDetail",plantInfo);
	}

	@Override
	public int deletePlantFile(int plantNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
	


}
