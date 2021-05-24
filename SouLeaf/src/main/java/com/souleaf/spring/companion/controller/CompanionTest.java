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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.souleaf.spring.companion.domain.Companion;
import com.souleaf.spring.companion.service.CompanionServiceImpl;
import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.domain.PlantFile;
import com.souleaf.spring.plant.service.PlantServiceImpl;

public class CompanionTest {

	private static Logger log = LoggerFactory.getLogger(CompanionController.class);

	public static void main(String[] args) {

		ModelAndView mv = null;
		Companion companion = null;
		companion.setCompanionNo(1);
		companion.setMemberNo(1);
		companion.setCompanionPickName("PickName");
		companion.setCompanionPickName("그림1.png");
		companion.setCompanionRepicName("20210512143854.png");
		companion.setCompanionLastWater("2021-05-26");
		companion.setCompanionNeedWater(null);
		MultipartFile uploadFile = null;
		HttpServletRequest request = null;
		PlantServiceImpl plantService = new PlantServiceImpl();
		CompanionServiceImpl CompanionService = new CompanionServiceImpl();
		
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
	}

	public static String saveFile(MultipartFile file, HttpServletRequest request) {
		// 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/companionFiles";
		// 저장 폴더 선택
		File folder = new File(savePath);
		// 폴더없으면 자동 생성
		if (!folder.exists()) {
			folder.mkdir();
		}
		// 파일명 변경하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originalFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + "."
				+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
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
}