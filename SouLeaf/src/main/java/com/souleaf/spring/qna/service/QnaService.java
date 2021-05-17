package com.souleaf.spring.qna.service;

import java.util.ArrayList;

import com.souleaf.spring.qna.domain.Ans;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.domain.QnaSearch;

public interface QnaService {
	public ArrayList<Qna> printQnaAll();
	public ArrayList<Qna> printSearchAll(QnaSearch search); 
	public Qna printQnaOne(int qId);
	public int registerQna(Qna qna);
	public int modifyQna(Qna qna);
	public int removeQna(int qId);
	
}
