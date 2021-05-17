package com.souleaf.spring.companion.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.souleaf.spring.companion.main.Companion;
import com.souleaf.spring.companion.service.CompanionService;

//@Controller
public class CompanionController {
	
//	@Autowired
	CompanionService CompanionService;
	
	// 반려식물 전체 조회
	@RequestMapping(value="CompanionList.kh", method=RequestMethod.GET)
	public ModelAndView boardListView(ModelAndView mv) {
		
		ArrayList<Companion> cList = CompanionService.printAll();
		if(!cList.isEmpty()) {
			mv.addObject("bList", cList);
			mv.setViewName("Companion/CompanionListView");
		}else {
			mv.addObject("msg", "게시글 전체조회 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 반려식물 상세 조회
	@RequestMapping(value="CompanionDetail.kh", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView boardDetail(ModelAndView mv, @RequestParam("companionNo") int companionNo) {
		
		Companion Companion = CompanionService.printOne(companionNo);
		if(Companion != null) {
			// 메소드 체이닝 방식
			mv.addObject("Companion", Companion).setViewName("Companion/CompanionDetailView");
		}else {
			mv.addObject("msg", "게시글 상세 조회 실패!");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 반려식물 등록화면
	@RequestMapping(value="CompanionWriteView.kh", method=RequestMethod.GET)
	public String boardWriteView() {
		return "Companion/CompanionWriteForm";
	}
	
	// 반려식물 등록
	@RequestMapping(value="CompanionRegister.kh", method=RequestMethod.POST)
	public ModelAndView boardRegister(ModelAndView mv,
							@ModelAttribute Companion companion,
							@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile,
							HttpServletRequest request) {
		// 서버에 파일을 저장하는 작업
		if(!uploadFile.getOriginalFilename().equals("")) {
			String renameFileName = saveFile(uploadFile, request);
			if(renameFileName != null) {
				companion.setCompanionPickName(uploadFile.getOriginalFilename());
				companion.setCompanionRepicName(renameFileName);
			}
		}
		// 디비에 데이터를 저장하는 작업
		int result = 0;
		String path = "";
		result = CompanionService.registerCompanion(companion);
		if(result > 0) {
			path = "redirect:CompanionList.kh";
		}else {
			mv.addObject("msg", "반려식물 등록 실패");
			path = "common/errorPage";
		}
		mv.setViewName(path);
		return mv;
	}
	
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		// 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\companionFiles";
		// 저장 폴더 선택
		File folder = new File(savePath);
		// 폴더없으면 자동 생성
		if(!folder.exists()) {
			folder.mkdir();
		}
		// 파일명 변경하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originalFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(new Date(System.currentTimeMillis())) 
								+ "." + originalFileName.substring(originalFileName.lastIndexOf(".")+1);
								// a.bc.jpg
		String filePath = folder + "\\" + renameFileName;
		// 파일저장
		try {
			file.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 리턴
		return renameFileName;
	}
	
	// 반려식물 수정화면
	@RequestMapping(value="companionModifyView.kh")
	public ModelAndView boardModifyView(ModelAndView mv, @RequestParam("companionNo") int companionNo) {
		
		Companion companion = CompanionService.printOne(companionNo);
		if(companion != null) {
			mv.addObject("board", companion).setViewName("companion/companionUpdateView");
		}else {
			mv.addObject("msg", "게시글 상제 조회 실패").setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	// 반려식물 수정
	@RequestMapping(value="companionUpdate.kh", method=RequestMethod.POST)
	public ModelAndView boardUpdate(ModelAndView mv
								, HttpServletRequest request
								, @ModelAttribute Companion companion
								, @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile) {
		// 파일 삭제 후 업로드 ( 수정 )
		if(reloadFile != null && !reloadFile.isEmpty()) {
			// 기존 파일 삭제
			if(companion.getCompanionPickName() != "") {
				deleteFile(companion.getCompanionRepicName(), request);
			}
			// 새 파일 업로드
			String renameFileName = saveFile(reloadFile, request);
			if(renameFileName != null) {
				companion.setCompanionPickName(reloadFile.getOriginalFilename());
				companion.setCompanionRepicName(renameFileName);
			}
		}
		// DB 수정
		int result = CompanionService.modifyCompanion(companion);
		if(result > 0) {
			mv.setViewName("redirect:companionList.kh");
		}else {
			mv.addObject("msg", "게시글 수정 실패").setViewName("common/errorPage");
		}
		return mv;
	}
	
	// 게시글 삭제(실제로는 상태 업데이트)
	@RequestMapping(value="companionDelete.kh", method=RequestMethod.GET)
	public String companionDelete(Model model, 
							@RequestParam("companionNo") int companion
							,@RequestParam("renameFilename") String renameFilename
							,HttpServletRequest request) {
		// 업로드된 파일 삭제
		if(renameFilename != "") {
			deleteFile(renameFilename, request);
		}
		
		// 디비에 데이터 업데이트
		int result = CompanionService.removeCompanion(companion);
		if(result > 0) {
			return "redirect:companionList.kh";
		}else {
			model.addAttribute("msg", "게시글 삭제 실패");
			return "common/errorPage";
		}
	}
	
	public void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\companionFiles";
		File file = new File(savePath + "\\" + fileName);
		if(file.exists()) {
			file.delete();
		}
	}
	

}
