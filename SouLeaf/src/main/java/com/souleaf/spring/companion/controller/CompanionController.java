package com.souleaf.spring.companion.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.souleaf.spring.diary.domain.Diary;
import com.souleaf.spring.diary.service.DiaryService;
import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantFile;
import com.souleaf.spring.plant.service.PlantService;

@Controller
public class CompanionController {
	
	@Autowired
	CompanionService companionService;
	@Autowired
	PlantService plantService;
	@Autowired
	private DiaryService diaryService;
	
	
	private Logger log = LoggerFactory.getLogger(CompanionController.class);
	
	// 반려식물 조회 화면 이동
	@RequestMapping(value="companionListView.kh", method=RequestMethod.GET)
	public ModelAndView companionLisAll(ModelAndView mv, HttpSession session) {
		ArrayList<Companion> cList = new ArrayList<Companion>();
		try {
			Member loginUser = (Member)session.getAttribute("loginUser");
			ArrayList<Companion> companionList = companionService.printmemberAll(loginUser.getMemberNo());
			ArrayList<Plant> pList = plantService.printAllList();
			mv.addObject("pList",pList);
			System.out.println(companionList.toString());
			log.info("반려식물 조회" + companionList.toString());
			for(Companion listOne : companionList) {
				// 식물 정보 조회
				Plant plant = plantService.printOne(listOne.getPlantNo());
				log.info("식물 정보 조회" + plant.toString());
				// 반려식물에 사진이 없다면
				if(listOne.getCompanionRepicName() == null) {
					// 식물도감에서 식물검색해서 첫번째 값 가져옴
					ArrayList<PlantFile> pfList = plantService.printFileList(listOne.getPlantNo());
					log.info("플랜트 파일 리스트" + pfList);
					loopOut:
					for(PlantFile pFile : pfList) {
						if(pFile.getPlantFileRename() != null) {
							listOne.setCompanionRepicName("resources/uploadFiles/plant/"+pFile.getPlantFileRename());
							break loopOut;
						}
					}
				} else {
					listOne.setCompanionRepicName("resources/uploadFiles/companion/"+listOne.getCompanionRepicName());
				}
				listOne.setPlantName(plant.getPlantName());
				listOne.setPlantWater(plant.getPlantWater());
				cList.add(listOne);
			}
			int listSize = cList.size();
			mv.addObject("listSize", listSize);
			mv.addObject("cList",cList);
			log.info("반려 식물 정보" + cList.toString());
		} catch (Exception e) {
			e.printStackTrace();
			log.info("반려식물 전체조회 실패");
			mv.setViewName("companion/companionListView");
		}
		mv.setViewName("companion/companionListView");
		return mv;
	}
	
//	// 반려식물 조회 화면 이동
//	@RequestMapping(value="companionListView.kh", method=RequestMethod.GET)
//	public ModelAndView companionLisAll(ModelAndView mv, HttpSession session) {
//		Member loginUser = (Member)session.getAttribute("loginUser");
//		ArrayList<Companion> cList = companionService.printmemberAll(loginUser.getMemberNo());
//		ArrayList<Plant> pList = plantService.printAllList();
//		int listSize = cList.size();
//		mv.addObject("listSize", listSize);
//		mv.addObject("pList", pList);
//		mv.setViewName("companion/companionListView");
//		
//		return mv;
//	}
	// 반려식물 전체 조회
//	@RequestMapping(value="companionList.kh")
//	public void companionList(HttpServletResponse response, HttpSession session) {
//		ArrayList<Companion> realList = new ArrayList<Companion>();
//		try {
//			Member loginUser = (Member)session.getAttribute("loginUser");
//			ArrayList<Companion> cList = companionService.printmemberAll(loginUser.getMemberNo());
//			System.out.println(cList.toString());
//			log.info("반려식물 전체조회 성공" + cList.toString());
//			for(Companion listOne : cList) {
//				// 식물 정보 조회
//				Plant plant = plantService.printOne(listOne.getPlantNo());
//				log.info("식물 정보 조회 성공" + plant.toString());
//				// 반려식물에 사진이 없다면
//				if(listOne.getCompanionRepicName() == null) {
//					// 식물도감에서 식물검색해서 첫번째 값 가져옴
//					ArrayList<PlantFile> pfList = plantService.printFileList(listOne.getPlantNo());
//					log.info("플랜트 파일 리스트" + pfList);
//					loopOut:
//					for(PlantFile pFile : pfList) {
//						if(pFile.getPlantFileRename() != null) {
//							listOne.setCompanionRepicName("resources/uploadFiles/plant/"+pFile.getPlantFileRename());
//							break loopOut;
//						}
//					}
//				} else {
//					listOne.setCompanionRepicName("resources/uploadFiles/companion/"+listOne.getCompanionRepicName());
//				}
//				listOne.setPlantName(plant.getPlantName());
//				listOne.setPlantWater(plant.getPlantWater());
//				realList.add(listOne);
//			}
//			log.info("최종 정보 만들기 성공?" + realList.toString());
//			if(! cList.isEmpty()) {
//				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//				gson.toJson(realList, response.getWriter());
//			}else {
//				System.out.println("데이터가 없습니다");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.info("반려식물 전체조회 실패");
//		}
//	}
	
	// 반려식물 상세 조회
//	@RequestMapping(value="companionDetail.kh", method=RequestMethod.GET)
//	public ModelAndView companionDetail(ModelAndView mv, @RequestParam("companionNo") int companionNo) {
//		
//		try {
//			Companion companion = companionService.printOne(companionNo);
//			mv.addObject("Companion", companion);
//			mv.setViewName("companion/companionDetailView");
//			log.info("반려식물 상세조회 성공");
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.info("반려식물 상세조회 실패");
//		}
//		return mv;
//	}
	
	// 반려식물 등록화면
//	@RequestMapping(value="companionWriteView.kh", method=RequestMethod.GET)
//	public String companionWriteView() {
//		return "companion/companionWriteForm";
//	}
	
	// 반려식물 등록
	@RequestMapping(value="companionRegister.kh", method=RequestMethod.POST)
	public ModelAndView companionRegister(ModelAndView mv,@ModelAttribute Companion companion, HttpServletRequest request,
							@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile) {
		try {
			// 서버에 파일을 저장하는 작업
			if(!uploadFile.getOriginalFilename().equals("")) {
				String renameFileName = saveFile(uploadFile, request);
				if (renameFileName != null) {
					companion.setCompanionPicName(uploadFile.getOriginalFilename());
					companion.setCompanionRepicName(renameFileName);
				}
			}
			Plant plant = plantService.printOne(companion.getPlantNo());
			// 캘린더 선언
			Calendar cal = Calendar.getInstance();
			// 데이트 포멧
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 입력받은 날짜 date 변환
			Date date = (Date) sdf.parse(companion.getCompanionLastWater());
			// 물준날 세팅
			cal.setTime(date);
			// Plant 줄주기 대입
			int plantWater = Integer.parseInt(plant.getPlantWater());
			// 물준날 + 물주기 날짜
			cal.add(Calendar.DATE, plantWater);
			// set 물 주는날 
			String dateToStr = sdf.format(cal.getTime());
			// 물 주는날 세팅
			companion.setCompanionNeedWater(dateToStr);
			
			Diary reDiary = new Diary();
            // 새로운 물 줘야하는날 등록
            reDiary.setDiaryStartDate(dateToStr);
            reDiary.setDiaryTitle(companion.getCompanionNick() + " 물줘!");
            reDiary.setdiaryColor("#4d638c");
            reDiary.setImgUrl("resources/images/watericon.png");
            diaryService.registerDiary(reDiary);
			
			// 디비에 데이터를 저장하는 작업
			companionService.registerCompanion(companion);
			
			log.info("반려식물 등록 성공");
		} catch (Exception e) {
			// 실패시에 화면이동과 화면에 얼러트로 경고창 띄어주면서 리스트로 가야하는데 이거에 대한 처리가 부족함
			// 여기서 result 로 99 든 뭐든 넘겨줘서 리절트값이 99라면 얼러트 창을 띄어주는식으로?
			e.printStackTrace();
			log.info("반려식물 등록 실패");
		}
		mv.setViewName("redirect:companionListView.kh");
		return mv;
	}
	
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		// 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/uploadFiles/companion";
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
//	@RequestMapping(value="companionModifyView.kh")
//	public ModelAndView companionModifyView(ModelAndView mv, @RequestParam("companionNo") int companionNo) {
//		
//		try {
//			Companion companion = companionService.printOne(companionNo);
//			mv.addObject("companion", companion).setViewName("companion/companionUpdateView");
//			log.info("반려식물 수정화면 불러오기 성공");
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.info("반려식물 수정화면 불러오기 실패");
//		}
//		return mv;
//	}
	
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
				if (companion.getCompanionPicName() != "") {
					deleteFile(companion.getCompanionRepicName(), request);
				}
				// 새 파일 업로드
				String renameFileName = saveFile(reloadFile, request);
				if (renameFileName != null) {
					companion.setCompanionPicName(reloadFile.getOriginalFilename());
					companion.setCompanionRepicName(renameFileName);
				}
			} else {
				// 기존 파일 삭제
				if (companion.getCompanionPicName() != "") {
					deleteFile(companion.getCompanionRepicName(), request);
				}
				ArrayList<PlantFile> plantFile = plantService.printFileList(companion.getPlantNo());
				companion.setCompanionPicName(plantFile.get(0).getPlantFilePath());
			}
			Plant plant = plantService.printOne(companion.getPlantNo());
			// 캘린더 선언
			Calendar cal = Calendar.getInstance();
			// 데이트 포멧
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 입력받은 날짜 date 변환
			java.util.Date date = (java.util.Date) sdf.parse(companion.getCompanionLastWater());
			// 물준날 세팅
			cal.setTime(date);
			// Plant 줄주기 대입
			int plantWater = Integer.parseInt(plant.getPlantWater());
			// 물준날 + 물주기 날짜
			cal.add(Calendar.DATE, plantWater);
			// set 물 주는날 
			String dateToStr = sdf.format(cal.getTime());
			// 물 주는날 세팅
			companion.setCompanionNeedWater(dateToStr);
			
			// DB 수정
			companionService.modifyCompanion(companion);
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
	public ModelAndView companionDelete(ModelAndView mv,  @ModelAttribute Companion companion ,HttpServletRequest request) {
		
		try {
			// 업로드된 파일 삭제
			if(companion.getCompanionRepicName() != "") {
				deleteFile(companion.getCompanionRepicName(), request);
			}
			log.info("반려식물 수정 실패");
			companionService.removeCompanion(companion.getCompanionNo());
		} catch (Exception e) {
			e.printStackTrace();
			log.info("반려식물 수정 실패");
		}
		mv.setViewName("redirect:companionList.kh");
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
