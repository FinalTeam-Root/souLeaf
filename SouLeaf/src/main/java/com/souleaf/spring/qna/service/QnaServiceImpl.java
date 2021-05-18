package com.souleaf.spring.qna.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.member.store.MemberStore;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.domain.QnaSearch;
import com.souleaf.spring.qna.store.QnaStore;

@Service
public class QnaServiceImpl implements QnaService {
	@Autowired
	private QnaStore qStore;
	
	
	@Override
	public ArrayList<Qna> printQnaAll() {
		ArrayList<Qna> qList = qStore.selectAllList();
		return qList;
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

	@Override
	public ArrayList<Qna> printQnaAll(PageInfo pi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}



}
