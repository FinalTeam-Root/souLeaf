package com.souleaf.spring.plant.domain;

import java.sql.Date;

public class PlantFile {
	private int plantFileNo;
	private String plantFileName;
	private String plantFilePath;
	private long plantFileSize;
	private Date plantFileDate;
	private int plantNo;
	
	public PlantFile() {
		// TODO Auto-generated constructor stub
	}

	public PlantFile(String plantFileName, String plantFilePath, long plantFileSize, int plantNo) {
		super();
		this.plantFileName = plantFileName;
		this.plantFilePath = plantFilePath;
		this.plantFileSize = plantFileSize;
		this.plantNo = plantNo;
	}



	public int getPlantFileNo() {
		return plantFileNo;
	}

	public void setPlantFileNo(int plantFileNo) {
		this.plantFileNo = plantFileNo;
	}

	public String getPlantFileName() {
		return plantFileName;
	}

	public void setPlantFileName(String plantFileName) {
		this.plantFileName = plantFileName;
	}

	public String getPlantFilePath() {
		return plantFilePath;
	}

	public void setPlantFilePath(String plantFilePath) {
		this.plantFilePath = plantFilePath;
	}

	public long getPlantFileSize() {
		return plantFileSize;
	}

	public void setPlantFileSize(long plantFileSize) {
		this.plantFileSize = plantFileSize;
	}

	public Date getPlantFileDate() {
		return plantFileDate;
	}

	public void setPlantFileDate(Date plantFileDate) {
		this.plantFileDate = plantFileDate;
	}
	
	public int getPlantNo() {
		return plantNo;
	}

	public void setPlantNo(int plantNo) {
		this.plantNo = plantNo;
	}

	@Override
	public String toString() {
		return "PlantFile [plantFileNo=" + plantFileNo + ", plantFileName=" + plantFileName + ", plantFilePath="
				+ plantFilePath + ", plantFileSize=" + plantFileSize + ", plantFileDate=" + plantFileDate + ", plantNo="
				+ plantNo + "]";
	}
	
	
}
