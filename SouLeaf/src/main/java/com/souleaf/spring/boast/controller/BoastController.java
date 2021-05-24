package com.souleaf.spring.boast.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastReply;
import com.souleaf.spring.boast.service.BoastService;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.common.Pagination;


@Controller
public class BoastController {

	@Autowired
	private BoastService bService;
	
	
	// 자랑하기 리스트 페이지 이동 및 출력

	@RequestMapping(value="boastListView.kh")
	public String boastListView() {
		return "Boast/boastListView";
	}
	
	
//	@RequestMapping(value="boastListView.kh", method=RequestMethod.GET)
//	public ModelAndView boastListView(ModelAndView mv
//									,@RequestParam(value="page", required=false) Integer page) {
//
//		int currentPage = (page != null) ? page : 1;
//	int listCount = bService.getListCount();
//		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
//		ArrayList<Boast> bList = bService.printAll(pi);
//		System.out.println("들어왔니?");
//		if(!bList.isEmpty()) {
//			mv.addObject("bList", bList);
//			mv.addObject("pi", pi);
//			mv.setViewName("boast/boastListView");
//			
//		}else {
//			mv.addObject("msg", "게시글 전체조회 실패");
//			mv.setViewName("common/errorPage");
//		}
//		return mv;
//	}	
	
	
	// 자랑하기 상세페이지 이동 및 출력
	@RequestMapping(value="boastDetail.kh", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView boastDetailView(ModelAndView mv,@RequestParam("boardNo") int boastNo) {
		// 조회수 증가
				bService.addReadCount(boastNo);
				
				// 게시글 상세 조회
				Boast boast = bService.printOne(boastNo);
				if(boast != null) {
					// 메소드 체이닝 방식
					mv.addObject("boast", boast).setViewName("boast/boastDetailView");
				}else {
					mv.addObject("msg", "게시글 상세 조회 실패!");
					mv.setViewName("common/errorPage");
				}
		return mv;
	
	}
	
	// 자랑하기 등록화면 이동
	@RequestMapping(value="boastWrite.kh") // 매핑 잘 확인하기
	public String boastWriterView() {
		return "Boast/boastWriteForm"; // 대소문자 확인 잘하기
	}
	
	// 자랑하기 게시글 등록
	public ModelAndView boastRegister(ModelAndView mv, Boast boast, MultipartFile uploadFile, Model model) {
		return null;
	}
	
	// 자랑하기 수정화면 이동
	public ModelAndView boastUpdateView(ModelAndView mv, int boastNo, Model model) {
		return null;
	}
	
	// 자랑하기 게시글 수정
	public ModelAndView boastUpdate(ModelAndView mv, Boast boast, MultipartFile uploadFile, Model model) {
		return null;
	}
	
	// 자랑하기 게시글 삭제
	public String boastDelete(int boastNo, Model model, HttpServletRequest request) {
		return "";
	}
	
	// 자랑하기 댓글 리스트 출력
	public ModelAndView boastReplyListView(ModelAndView mv, int boastNo, BoastReply reply, Model model) {
		return null;
	}
	
	// 자랑하기 댓글 등록
	public ModelAndView boastReplyRegister(ModelAndView mv, int boastNo, BoastReply reply,MultipartFile uploadFile, Model model ) {
		return null;
	}
	
	// 자랑하기 댓글 수정
	public ModelAndView boastReplyUpdate(ModelAndView mv, int boastNo, BoastReply reply, MultipartFile uploadFile, Model model) {
		return null;
		
	}
	
	// 자랑하기 댓글 삭제
	public String boastReplyDelete(int boastNo, Model model) {
		return "";
	}
	
	// 파일 저장
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		return "";
	}
	
	// 저장된 파일 삭제
	public void deleteFile(String fileName, HttpServletRequest request) {
		
	}
	
	// 자랑하기 조회수 증가
	
	public ModelAndView boastAddReadCount(ModelAndView mv, int boastNo, Model model) {
		return null;
	}
	
	// 해시태그 출력
	public String getHashTagList(Boast boast, Model model) {
		return "";
	}

	// 자랑하기 좋아요 증가
	public ModelAndView boastLikeNo(ModelAndView mv, int boastNo, Model model) {
		return null;
	}
	
	// 자랑하기 대댓글 등록
	
	// 자랑하기 대댓글 수정
	
	// 자랑하기 대댓글 삭제
}