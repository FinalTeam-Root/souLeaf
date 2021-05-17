package com.souleaf.spring.clinic.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.domain.ClinicCommnet;
import com.souleaf.spring.clinic.store.ClinicStore;
import com.souleaf.spring.common.PageInfo;

//@Service
public class ClinicServiceImpl implements ClinicService{

//	@Autowired
	private ClinicStore cStore;
	
	@Override
	public int getListCount() {
		return cStore.selectListCount();
	}

	@Override
	public ArrayList<Clinic> printAll(PageInfo pi) {
		return cStore.selectAllList(pi);
	}

	@Override
	public int addReadCount(int clinicNo) {
		return cStore.addReadCount(clinicNo);
	}

	@Override
	public Clinic printOne(int clinicNo) {
		return cStore.selectOne(clinicNo);
	}

	@Override
	public int registerBoard(Clinic clinic) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyBoard(Clinic clinic) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeBoard(int clinicNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ClinicCommnet> printAllReply(int clinicNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerReply(ClinicCommnet clinicCommnet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyReply(ClinicCommnet clinicCommnet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeReply(ClinicCommnet clinicCommnet) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
