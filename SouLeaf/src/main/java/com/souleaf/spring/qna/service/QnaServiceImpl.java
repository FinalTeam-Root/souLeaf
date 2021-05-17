package com.souleaf.spring.qna.service;

import java.util.ArrayList;

import com.souleaf.spring.member.store.MemberStore;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.domain.QnaSearch;
import com.souleaf.spring.qna.store.QnaStore;

public class QnaServiceImpl implements QnaService {
	private QnaStore qstore;

	@Override
	public ArrayList<Qna> printQnaAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Qna> printSearchAll(QnaSearch search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Qna printQnaOne(int qId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerQna(Qna qna) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyQna(Qna qna) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeQna(int qId) {
		// TODO Auto-generated method stub
		return 0;
	}



}
