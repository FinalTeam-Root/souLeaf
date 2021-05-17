package com.souleaf.spring.boast.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastReply;
import com.souleaf.spring.boast.service.BoastService;

public class BoastController {

	private BoastService bService;
	
	
	// 자랑하기 리스트 페이지 이동 및 출력
	public ModelAndView boastListView(ModelAndView mv, Integer page, Model model) {
		return null; 
		
	}
	
	// 자랑하기 상세페이지 이동 및 출력
	public ModelAndView boastDetailView(ModelAndView mv, int boastNo, Model model) {
		return null;
	
	}
	
	// 자랑하기 등록화면 이동
	public String boastWriterView(Model model) {
		return "test";
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
}