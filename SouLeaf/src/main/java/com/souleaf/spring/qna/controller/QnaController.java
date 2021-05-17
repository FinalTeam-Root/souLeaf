package com.souleaf.spring.qna.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.domain.QnaSearch;
import com.souleaf.spring.qna.service.QnaService;

public class QnaController {
	private QnaService qService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String qnaList(Model model) {
		return null;
		
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String qnaDetail(@RequestParam("qnaNo") int qnaNo, 
								Model model) {
									return null;
		
	}
	@RequestMapping(value="", method=RequestMethod.GET)
	public String qnaSearch(@ModelAttribute QnaSearch search, Model model) {
		return null;
		
	}
	@RequestMapping(value="qnaWriteView.kh", method=RequestMethod.GET)
	public String qnaWriteView() {
		return "";
	}

		
	}
	


