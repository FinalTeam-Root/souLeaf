package com.souleaf.spring.plant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.service.PlantService;
@Controller
public class PlantController {
	@Autowired
	private PlantService pService;
	
		// 식물도감 리스트 페이지 이동 및 출력
		@RequestMapping(value="plantListView.kh")
		public ModelAndView plantListView(ModelAndView mv, Integer page, Model model, HttpServletRequest request) {
			HttpSession session = request.getSession();
			session.setAttribute("nav", "plant");
			mv.setViewName("plant/plantListView");
			
			return mv;
		}
		
		// 식물도감 상세페이지 이동 및 출력
		public ModelAndView plantDetailView(ModelAndView mv,int plantNo, Model model) {
			return null;
		}
		
		// 식물도감 등록화면 이동
		@RequestMapping(value="plantWrite.kh")
		public String plantWriterView() {
			return "plant/plantWrite";
		}
		
		// 식물도감 게시글 등록
		public ModelAndView plantRegister(ModelAndView mv, Plant plant, MultipartFile uploadFile, Model model) {
			return null;
		}

		// 식물도감 수정화면 이동
		public ModelAndView plantUpdateView(ModelAndView mv, int plantNo, Model model) {
			return null;
		}
		
		// 식물도감 게시글 수정
		public ModelAndView plantUpdate(ModelAndView mv, Plant plant,MultipartFile uploadFile, Model model) {
			return null;
		}
		
		// 식물도감 게시글 삭제
		public String plantDelete(int plantNo, Model model, HttpServletRequest request) {
			return "";
		}
		
		
		// 파일 저장
		public String saveFile(MultipartFile file, HttpServletRequest request) {
			return "";
		}
		
		// 저장된 파일 삭제
		public void deleteFile(String fileName, HttpServletRequest request) {
			
		}
	
	

}
