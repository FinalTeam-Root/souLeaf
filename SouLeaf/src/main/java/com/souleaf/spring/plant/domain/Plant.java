package com.souleaf.spring.plant.domain;

import java.sql.Date;

public class Plant {
	private  int plantNo;
	private String plantName;
	private String plantEngname;
	private String plantPlantae;
	private String plantKind;
	private String plantProperty;
	private String plantLeaf;
	private String plantDetail;
	private String plantWater;
	private String plantEnvi;
	private String plantHumidity;
	private Date plantDate;
	private int plantCount;
	private int plantPoint;
	
	private int plantfileNo;
	private String plantfileName;
	private String plantfilePath;
	private long plantfileSize;
	private Date plantfileDate;
	
	public Plant() {
		// TODO Auto-generated constructor stub
	}

	public int getPlantNo() {
		return plantNo;
	}

	public void setPlantNo(int plantNo) {
		this.plantNo = plantNo;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getPlantEngname() {
		return plantEngname;
	}

	public void setPlantEngname(String plantEngname) {
		this.plantEngname = plantEngname;
	}

	public String getPlantPlantae() {
		return plantPlantae;
	}

	public void setPlantPlantae(String plantPlantae) {
		this.plantPlantae = plantPlantae;
	}

	public String getPlantKind() {
		return plantKind;
	}

	public void setPlantKind(String plantKind) {
		this.plantKind = plantKind;
	}

	public String getPlantProperty() {
		return plantProperty;
	}

	public void setPlantProperty(String plantProperty) {
		this.plantProperty = plantProperty;
	}

	public String getPlantLeaf() {
		return plantLeaf;
	}

	public void setPlantLeaf(String plantLeaf) {
		this.plantLeaf = plantLeaf;
	}

	public String getPlantDetail() {
		return plantDetail;
	}

	public void setPlantDetail(String plantDetail) {
		this.plantDetail = plantDetail;
	}

	public String getPlantWater() {
		return plantWater;
	}

	public void setPlantWater(String plantWater) {
		this.plantWater = plantWater;
	}

	public String getPlantEnvi() {
		return plantEnvi;
	}

	public void setPlantEnvi(String plantEnvi) {
		this.plantEnvi = plantEnvi;
	}

	public String getPlantHumidity() {
		return plantHumidity;
	}

	public void setPlantHumidity(String plantHumidity) {
		this.plantHumidity = plantHumidity;
	}

	public Date getPlantDate() {
		return plantDate;
	}

	public void setPlantDate(Date plantDate) {
		this.plantDate = plantDate;
	}

	public int getPlantCount() {
		return plantCount;
	}

	public void setPlantCount(int plantCount) {
		this.plantCount = plantCount;
	}

	public int getPlantPoint() {
		return plantPoint;
	}

	public void setPlantPoint(int plantPoint) {
		this.plantPoint = plantPoint;
	}

	public int getPlantfileNo() {
		return plantfileNo;
	}

	public void setPlantfileNo(int plantfileNo) {
		this.plantfileNo = plantfileNo;
	}

	public String getPlantfileName() {
		return plantfileName;
	}

	public void setPlantfileName(String plantfileName) {
		this.plantfileName = plantfileName;
	}

	public String getPlantfilePath() {
		return plantfilePath;
	}

	public void setPlantfilePath(String plantfilePath) {
		this.plantfilePath = plantfilePath;
	}

	public long getPlantfileSize() {
		return plantfileSize;
	}

	public void setPlantfileSize(long plantfileSize) {
		this.plantfileSize = plantfileSize;
	}

	public Date getPlantfileDate() {
		return plantfileDate;
	}

	public void setPlantfileDate(Date plantfileDate) {
		this.plantfileDate = plantfileDate;
	}

	@Override
	public String toString() {
		return "Plant [plantNo=" + plantNo + ", plantName=" + plantName + ", plantEngname=" + plantEngname
				+ ", plantPlantae=" + plantPlantae + ", plantKind=" + plantKind + ", plantProperty=" + plantProperty
				+ ", plantLeaf=" + plantLeaf + ", plantDetail=" + plantDetail + ", plantWater=" + plantWater
				+ ", plantEnvi=" + plantEnvi + ", plantHumidity=" + plantHumidity + ", plantDate=" + plantDate
				+ ", plantCount=" + plantCount + ", plantPoint=" + plantPoint + ", plantfileNo=" + plantfileNo
				+ ", plantfileName=" + plantfileName + ", plantfilePath=" + plantfilePath + ", plantfileSize="
				+ plantfileSize + ", plantfileDate=" + plantfileDate + "]";
	}
	
	

	
}
