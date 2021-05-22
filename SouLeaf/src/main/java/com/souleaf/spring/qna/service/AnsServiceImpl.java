package com.souleaf.spring.qna.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.qna.domain.Ans;
import com.souleaf.spring.qna.domain.AnsSearch;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.store.AnsStore;

@Service
public class AnsServiceImpl implements AnsService{
	private AnsStore aStore;

	

	@Override
	public Ans printAnsOne(int aId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerAns(Ans ans) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyAns(Ans ans) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeAns(int aId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addReadCount(int ansNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Ans> printSearchAll(AnsSearch search) {
		ArrayList<Ans> searchList = aStore.selectSearchList(search);
		return searchList;
	}

	@Override
	public ArrayList<Ans> printAnsAll(PageInfo pi) {
		return aStore.selectAllList(pi);
	}

}

