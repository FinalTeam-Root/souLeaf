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
	
	
	@RequestMapping(value="qnaListView.kh", method=RequestMethod.GET)
	public ModelAndView qnaListView(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int listCount = qService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);	
		ArrayList<Qna> qList = qService.printQnaAll(pi);
		return mv;
	}
	
//	@RequestMapping(value="", method=RequestMethod.GET)
//	public String qnaDetail(@RequestParam("qnaNo") int qnaNo, 
//								Model model) {
//									return null;
//		
//	}
//	@RequestMapping(value="", method=RequestMethod.GET)
//	public String qnaSearch(@ModelAttribute QnaSearch search, Model model) {
//		return null;
//		
//	}
//	@RequestMapping(value="qnaWriteView.kh", method=RequestMethod.GET)
//	public String qnaWriteView() {
//		return "";
//	}

		
	}
	


