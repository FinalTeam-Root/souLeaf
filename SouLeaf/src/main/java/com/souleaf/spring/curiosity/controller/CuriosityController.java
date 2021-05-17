package com.souleaf.spring.curiosity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.domain.CuriosityReply;
import com.souleaf.spring.curiosity.service.CuriosityService;
import com.souleaf.spring.plant.domain.Plant;

public class CuriosityController {

	private CuriosityService cService;
	
	// 궁금해요 리스트 페이지 이동 및 출력
	public ModelAndView curiosityListView(ModelAndView mv, Integer page, Model model) {
		return null;
	}
	
	// 궁금해요 상세페이지 이동 및 출력
	public ModelAndView curiosityDetailView(ModelAndView mv,int curiosityNo, Model model) {
		return null;
	}
	
	// 궁금해요 등록화면 이동
	public String curiosityWriterView(Model model) {
		return "";
	}
	
	// 궁금해요 게시글 등록
	public ModelAndView curiosityRegister(ModelAndView mv, Curiosity curiosity, MultipartFile uploadFile, Model model) {
		return null;
	}

	// 궁금해요 수정화면 이동
	public ModelAndView curiosityUpdateView(ModelAndView mv, int curiosityNo, Model model) {
		return null;
	}
	
	// 궁금해요 게시글 수정
	public ModelAndView curiosityUpdate(ModelAndView mv, Curiosity curiosity,MultipartFile uploadFile, Model model) {
		return null;
	}
	
	// 궁금해요 게시글 삭제
	public String curiosityDelete(int curiosityNo, Model model, HttpServletRequest request) {
		return "";
	}
	
	// 궁금해요 댓글 리스트 출력
	public ModelAndView curiosityReplyListView(ModelAndView mv, int curiosityNo, CuriosityReply reply, Model model) {
		return null;
	}
	
	// 궁금해요 댓글 등록
	public ModelAndView curiosityReplyRegister(ModelAndView mv, int curiosityNo, CuriosityReply reply, MultipartFile uploadFile, Model model) {
		return null;
	}
	
	// 궁금해요 댓글 수정
	public ModelAndView curiosityReplyUpdate(ModelAndView mv, int curiosityNo, CuriosityReply reply, MultipartFile uploadFile, Model model) {
		return null;
	}
	
	// 궁금해요 댓글 삭제
	public String curiosityReplyDelete(int curiosityNo, Model model) {
		return "";
	}
	
	// 파일 저장
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		return "";
	}
	
	// 저장된 파일 삭제
	public void deleteFile(String fileName, HttpServletRequest request) {
		
	}
	
	// 궁금해요 조회수 증가
	public ModelAndView curiosityAddCount(ModelAndView mv, int curiosityNo, Model model) {
		return null;
	}
	
	// 해시태그 출력
	public String getHashTagList(Plant plant, Model model) {
		return "";
	}
	
}
