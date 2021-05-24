package com.souleaf.spring.companion.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.souleaf.spring.companion.domain.Companion;
import com.souleaf.spring.companion.service.CompanionService;
import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantFile;
import com.souleaf.spring.plant.service.PlantService;

@Controller
public class CompanionController {
	
	@Autowired
	CompanionService CompanionService;
	@Autowired
	PlantService plantService;
	
	
	private Logger log = LoggerFactory.getLogger(CompanionController.class);
	
	// 반려식물 전체 조회
	@RequestMapping(value="CompanionList.kh", method=RequestMethod.GET)
	public ModelAndView companionListView(ModelAndView mv) {
		
		try {
			ArrayList<Companion> cList = CompanionService.printAll();
			mv.addObject("bList", cList);
			mv.setViewName("Companion/CompanionListView");
			log.info("반려식물 전체조회 성공");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("반려식물 전체조회 실패");
		}
		return mv;
	}
	
	// 반려식물 상세 조회
	@RequestMapping(value="CompanionDetail.kh", method=RequestMethod.GET)
	public ModelAndView companionDetail(ModelAndView mv, @RequestParam("companionNo") int companionNo) {
		
		try {
			Companion Companion = CompanionService.printOne(companionNo);
			mv.addObject("Companion", Companion);
			mv.setViewName("Companion/CompanionDetailView");
			log.info("반려식물 상세조회 성공");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("반려식물 상세조회 실패");
		}
		return mv;
	}
	
	// 반려식물 등록화면
	@RequestMapping(value="CompanionWriteView.kh", method=RequestMethod.GET)
	public String companionWriteView() {
		return "Companion/CompanionWriteForm";
	}
	
	// 반려식물 등록
	@RequestMapping(value="CompanionRegister.kh", method=RequestMethod.POST)
	public ModelAndView companionRegister(ModelAndView mv,
							@ModelAttribute Companion companion,
							@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile,
							HttpServletRequest request) {
		try {
			// 서버에 파일을 저장하는 작업
			if (!uploadFile.getOriginalFilename().equals("")) {
				String renameFileName = saveFile(uploadFile, request);
				if (renameFileName != null) {
					companion.setCompanionPickName(uploadFile.getOriginalFilename());
					companion.setCompanionRepicName(renameFileName);
				}
			} else {
				ArrayList<PlantFile> plantFile = plantService.printFileList(companion.getPlantNo());
				companion.setCompanionPickName(plantFile.get(0).getPlantFilePath());
			}
			Plant plant = plantService.printOne(companion.getPlantNo());
			// 캘린더 선언
			Calendar cal = Calendar.getInstance();
			// 물준날 세팅
			cal.setTime(companion.getCompanionLastWater());
			// Plant 줄주기 대입
			int plantWater = Integer.parseInt(plant.getPlantWater());
			// 물준날 + 물주기 날짜
			cal.add(Calendar.DATE, plantWater);
			// set 물 주는날 
			companion.setCompanionNeedWater((Date) cal.getTime());
			
			// 디비에 데이터를 저장하는 작업
			CompanionService.registerCompanion(companion);
			mv.setViewName("redirect:CompanionList.kh");
			log.info("반려식물 상세조회 성공");
		} catch (Exception e) {
			// 실패시에 화면이동과 화면에 얼러트로 경고창 띄어주면서 리스트로 가야하는데 이거에 대한 처리가 부족함
			// 여기서 result 로 99 든 뭐든 넘겨줘서 리절트값이 99라면 얼러트 창을 띄어주는식으로?
			e.printStackTrace();
			log.info("반려식물 상세조회 실패");
			mv.setViewName("redirect:CompanionList.kh");
		}
		return mv;
	}
	
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		// 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/companionFiles";
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
		String filePath = folder + "/" + renameFileName;
		// 파일저장
		try {
			file.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 리턴
		return renameFileName;
	}
	
	// 반려식물 수정화면
	@RequestMapping(value="companionModifyView.kh")
	public ModelAndView companionModifyView(ModelAndView mv, @RequestParam("companionNo") int companionNo) {
		
		try {
			Companion companion = CompanionService.printOne(companionNo);
			mv.addObject("companion", companion).setViewName("companion/companionUpdateView");
			log.info("반려식물 수정화면 불러오기 성공");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("반려식물 수정화면 불러오기 실패");
		}
		return mv;
	}
	
	// 반려식물 수정
	@RequestMapping(value="companionUpdate.kh", method=RequestMethod.POST)
	public ModelAndView companionUpdate(ModelAndView mv
								, HttpServletRequest request
								, @ModelAttribute Companion companion
								, @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile) {
		try {
			// 파일 삭제 후 업로드 ( 수정 )
			if (reloadFile != null && !reloadFile.isEmpty()) {
				// 기존 파일 삭제
				if (companion.getCompanionPickName() != "") {
					deleteFile(companion.getCompanionRepicName(), request);
				}
				// 새 파일 업로드
				String renameFileName = saveFile(reloadFile, request);
				if (renameFileName != null) {
					companion.setCompanionPickName(reloadFile.getOriginalFilename());
					companion.setCompanionRepicName(renameFileName);
				}
			} else {
				// 기존 파일 삭제
				if (companion.getCompanionPickName() != "") {
					deleteFile(companion.getCompanionRepicName(), request);
				}
				ArrayList<PlantFile> plantFile = plantService.printFileList(companion.getPlantNo());
				companion.setCompanionPickName(plantFile.get(0).getPlantFilePath());
			}

			// 캘린더 선언
			Calendar cal = Calendar.getInstance();
			// 물준날 세팅
			cal.setTime(companion.getCompanionLastWater());
			// 식물정도 가져오기
			Plant plant = plantService.printOne(companion.getPlantNo());
			// Plant 줄주기 대입
			int plantWater = Integer.parseInt(plant.getPlantWater());
			// 물준날 + 물주기 날짜
			cal.add(Calendar.DATE, plantWater);
			// set 물 주는날 
			companion.setCompanionNeedWater((Date) cal.getTime());
			
			// DB 수정
			CompanionService.modifyCompanion(companion);
			mv.setViewName("redirect:companionList.kh");
			log.info("반려식물 수정 성공");
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("redirect:companionList.kh");
			log.info("반려식물 수정 실패");
		}
		return mv;
	}
	
	// 게시글 삭제
	@RequestMapping(value="companionDelete.kh", method=RequestMethod.GET)
	public ModelAndView companionDelete(ModelAndView mv, 
							@RequestParam("companionNo") int companion
							,@RequestParam("renameFilename") String renameFilename
							,HttpServletRequest request) {
		
		try {
			// 업로드된 파일 삭제
			if(renameFilename != "") {
				deleteFile(renameFilename, request);
			}
			log.info("반려식물 수정 실패");
			CompanionService.removeCompanion(companion);
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("redirect:companionList.kh");
			log.info("반려식물 수정 실패");
		}
		return mv;
	}
	
	public void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/companionFiles";
		File file = new File(savePath + "/" + fileName);
		if(file.exists()) {
			file.delete();
		}
	}
}
