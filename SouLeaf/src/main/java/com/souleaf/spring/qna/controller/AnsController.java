package com.souleaf.spring.qna.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.souleaf.spring.qna.domain.QnaSearch;
import com.souleaf.spring.qna.service.AnsService;

public class AnsController {
	private AnsService aService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String ansList(Model model) {
		return null;
		
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String ansDetail(@RequestParam("ansNo") int ansNo, 
								Model model) {
									return null;
		
	}
	
		
	
	@RequestMapping(value="ansWriteView.kh", method=RequestMethod.GET)
	public String ansWriteView() {
		return "";
	}
}
