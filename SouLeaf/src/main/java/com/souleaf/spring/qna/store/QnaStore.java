package com.souleaf.spring.qna.store;

import java.util.ArrayList;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.domain.QnaSearch;

public interface QnaStore {

	public ArrayList<Qna> selectAllList(PageInfo pi); // 전체 리스트 출력
	public ArrayList<Qna> selectSearchList(QnaSearch search);
	public int addReadCount(int qnaNo);
	public int selectListCount();
	public Qna selectOne(int qId);
	public int insertQna(Qna qna);
	public int updateQna(Qna qna);
	public int deleteQna(int qId);
}
