package com.souleaf.spring.clinic.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.domain.ClinicLike;
import com.souleaf.spring.clinic.domain.ClinicReply;
import com.souleaf.spring.clinic.domain.ClinicSearch;
import com.souleaf.spring.clinic.store.ClinicStore;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.plant.domain.Plant;

@Service
public class ClinicServiceImpl implements ClinicService{

	@Autowired
	private ClinicStore cStore;
	
	@Override
	public int getClinicListCount() {
		return cStore.selectClinicListCount();
	}
	
	@Override
	public ArrayList<Clinic> printAllList(PageInfo pi) {
		return cStore.selectAllList(pi);
	}

	@Override
	public Clinic printOne(int clinicNo) {
		return cStore.selectOne(clinicNo);
	}

	@Override
	public int registerClinic(Clinic clinic) {
		return cStore.insertClinic(clinic);
	}

	@Override
	public int modifyClinic(Clinic clinic) {
		return cStore.updateClinic(clinic);
	}

	@Override
	public int removeClinic(int clinicNo) {
		// TODO Auto-generated method stub
		return cStore.deleteClinic(clinicNo);
	}

	@Override
	public ArrayList<Clinic> printSearchAllList(ClinicSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Plant> printAllhashTagList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addReadCount(int clinicNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ClinicReply> printAllClinicReply(int clinicNo) {
		return cStore.selectAllClinicReply(clinicNo);
	}

	@Override
	public int registerClinicReply(ClinicReply reply) {
		return cStore.insertClinicReply(reply);
	}

	@Override
	public int modifyClinicReply(ClinicReply reply) {
		return cStore.updateClinicReply(reply);
	}

	@Override
	public int removeClinicReply(int clinicNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addViewCount(int clinicNo) {
		cStore.updateViewCount(clinicNo);
		
	}

	// 좋아요 확인
	@Override
	public ClinicLike printLike(ClinicLike clinicLike) {
		return cStore.selectLike(clinicLike);
	}

	@Override
	public ArrayList<Clinic> printAll() {
		return cStore.selectAll();
	}

	@Override
	public int removeAdminClinic(HashMap<String, String> map) {
		return cStore.deleteAdminClinic(map);
	}
	
}
