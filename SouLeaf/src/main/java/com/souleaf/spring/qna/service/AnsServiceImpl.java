package com.souleaf.spring.qna.service;

import java.util.ArrayList;

import com.souleaf.spring.qna.domain.Ans;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.store.AnsStore;

public class AnsServiceImpl implements AnsService{
	private AnsStore astore;

	@Override
	public ArrayList<Ans> printQnaAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Qna printAnsOne(int aId) {
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
}
