package com.souleaf.spring.plant.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantFile;
import com.souleaf.spring.plant.domain.PlantInfo;
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
		
		// 식물도감 리스트 출력
		@ResponseBody
		@RequestMapping(value="plantList.kh")
		public void getPlantList(HttpServletResponse response, @RequestParam("current") int current) throws Exception {
			ArrayList<Plant> pList = pService.printAllList();
			if(! pList.isEmpty()) {
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
				gson.toJson(pList, response.getWriter());
			}else {
				System.out.println("데이터가 없습니다");
			}
		}
		
		@RequestMapping(value="plantSelect.kh")
		public void getPlantSelectList(HttpServletResponse response,@RequestParam("plantKind") String plantKind,@RequestParam("plantProperty") String plantProperty,@RequestParam("plantLeaf") String plantLeaf) throws Exception{
			System.out.println(plantKind);
			System.out.println(plantProperty);
			System.out.println(plantLeaf);
			HashMap<String, String> plantSelect = new HashMap<String, String>();
			plantSelect.put("plantKind", plantKind);
			plantSelect.put("plantProperty", plantProperty);
			plantSelect.put("plantLeaf", plantLeaf);
			
			ArrayList<Plant> pList = pService.printSelectList(plantSelect);
			if(!pList.isEmpty()) {
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
				gson.toJson(pList, response.getWriter());
			}else {
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
				gson.toJson(pList, response.getWriter());
				System.out.println("데이터가 없습니다");
			}
		}
		
		// 식물도감 검색페이지 이동 및 출력
		@RequestMapping(value="plantSearch.kh")
		public ModelAndView plantSearchView(ModelAndView mv,@RequestParam("search") String search) {
			ArrayList<Plant> pList = pService.printSearchAllList(search);
			if(! pList.isEmpty()) {
				mv.addObject("pList",pList).setViewName("plant/plantSearchView");
			}else {
				mv.addObject("pList",null).addObject("search",search).setViewName("plant/plantSearchView");
			}
			return mv;
		}
		
		
		// 식물도감 상세페이지 이동 및 출력
		@RequestMapping(value="plantDetail.kh")
		public ModelAndView plantDetailView(ModelAndView mv,@RequestParam("plantNo") int plantNo, Model model) {
			Plant plant = pService.printOne(plantNo);
			PlantInfo pInfo = pService.printOneInfo(plantNo);
			ArrayList<PlantFile> pfList = pService.printFileList(plantNo);
			mv.addObject("plant",plant);
			mv.addObject("pInfo",pInfo);
			mv.addObject("pfList",pfList);
			mv.setViewName("plant/plantDetail");
			return mv;
		}
		
		// 식물도감 등록화면 이동
		@RequestMapping(value="plantWrite.kh")
		public String plantWriterView() {
			return "plant/plantWrite";
		}
		
		    
		// 식물도감 게시글 등록
		@RequestMapping(value="plantRegister.kh", method = RequestMethod.POST)
		public ModelAndView plantRegister(ModelAndView mv, @ModelAttribute Plant plant, @ModelAttribute PlantInfo plantInfo, MultipartHttpServletRequest multipartRequest, HttpServletRequest request,Model model) {
			List<MultipartFile> fList = multipartRequest.getFiles("ufile");
			  String root = request.getSession().getServletContext().getRealPath("resources");
			  
		      String filePath = root+"/uploadFiles/plant"; //설정파일로 뺀다.
		        File folder = new File(filePath);
		        if(!folder.exists()) {
		        	folder.mkdir();
		        }
		        int result = pService.registerPlant(plant, plantInfo, fList, filePath);
		       
			if(result > 0) {
				mv.setViewName("redirect:plantListView.kh");
			}else {
				mv.setViewName("common/errorPage");
			}
			return mv;
		}

		// 식물도감 수정화면 이동
		@RequestMapping(value="plantUpdateView.kh")
		public ModelAndView plantUpdateView(ModelAndView mv, @RequestParam("plantNo") int plantNo, Model model) {
			Plant plant = pService.printOne(plantNo);
			PlantInfo pInfo = pService.printOneInfo(plantNo);
			ArrayList<PlantFile> pfList = pService.printFileList(plantNo);
			mv.addObject("plant",plant);
			mv.addObject("pInfo",pInfo);
			mv.addObject("pfList",pfList);
			mv.setViewName("plant/plantUpdate");
			return mv;
		}
		
		// 식물도감 게시글 수정
		@RequestMapping(value="plantUpdate.kh", method = RequestMethod.POST)
		public ModelAndView plantUpdate(ModelAndView mv, @ModelAttribute Plant plant, @ModelAttribute PlantInfo plantInfo, MultipartHttpServletRequest multipartRequest, HttpServletRequest request,Model model) {
			List<MultipartFile> fList = multipartRequest.getFiles("ufile");
			  String root = request.getSession().getServletContext().getRealPath("resources");
			  
		      String filePath = root+"/uploadFiles/plant"; //설정파일로 뺀다.
		        File folder = new File(filePath);
		        if(!folder.exists()) {
		        	folder.mkdir();
		        }
		        int result = pService.modifyPlant(plant, plantInfo, fList, filePath);
		       
			if(result > 0) {
				mv.setViewName("redirect:plantListView.kh");
			}else {
				mv.setViewName("common/errorPage");
			}
			return mv;
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
		@ResponseBody
		@RequestMapping(value="deleteFile.kh")
		public String deleteFile(@ModelAttribute PlantFile plantFile,HttpServletRequest request,HttpServletResponse reponse) {
			deleteFile(plantFile.getPlantFileRename(),request);
			int result = pService.removeFile(plantFile);
			if(result > 0) {
				return result+"";
				
			}else {
				return result+"";
			}
		}
	
		//  파일 삭제
		public void deleteFile(String fileName,HttpServletRequest request) {
			String root = request.getSession().getServletContext().getRealPath("resources");
			String savePath = root + "/uploadFiles/plant";
			File file = new File(savePath + "/" +fileName);
			if(file.exists()) {
				file.delete();
			}
		}
	

}
