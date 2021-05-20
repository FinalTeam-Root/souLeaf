package com.souleaf.spring.qna.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.common.Pagination;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.domain.QnaSearch;
import com.souleaf.spring.qna.service.QnaService;

@Controller
public class QnaController {
	@Autowired
	private QnaService qService;
	private Logger log = LoggerFactory.getLogger(QnaController.class);

	// 관리자가 볼땐 전체조회가 필요
	@RequestMapping(value = "qnaListView.kh", method = RequestMethod.GET)
	public ModelAndView qnaListView(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		try {
			int listCount = qService.getListCount();
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			ArrayList<Qna> qList = qService.printQnaAll(pi);
			mv.addObject("qList", qList);
			mv.addObject("pi", pi);
			mv.setViewName("qna/qnaListView");
			log.info("QnA 전체 조회 성공");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("QnA 전체 조회 실패");
		}
		return mv;
	}

	// QnA 상세 조회
	@RequestMapping(value = "qnaDetail.kh", method = RequestMethod.GET)
	public ModelAndView qnaDetail(ModelAndView mv, @RequestParam("qnaNo") int qnaNo) {

		try {

			qService.addReadCount(qnaNo);
			Qna qna = qService.printQnaOne(qnaNo);
			mv.addObject("qna", qna);
			mv.setViewName("qna/qnaDetailView");
			log.info("QnA 상세 조회 성공");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("QnA 상세 조회 실패");
		}

		return mv;
	}

	// QnA 검색
	@RequestMapping(value = "qnaSearch.kh", method = RequestMethod.GET)
	public ModelAndView qnaSearch(ModelAndView mv, @ModelAttribute QnaSearch search) {
		try {

			ArrayList<Qna> searchList = qService.printSearchAll(search);
			mv.addObject("qList", searchList);
			mv.addObject("search", search);
			log.info("QnA 검색 성공");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("QnA 검색 실패");
		}
		return mv;
	}
	
	// QnA 등록화면
	@RequestMapping(value = "qnaWriteView.kh", method = RequestMethod.GET)
	public String qnaWriteView() {
		return "qna/qnaWriteForm";
	}

}
