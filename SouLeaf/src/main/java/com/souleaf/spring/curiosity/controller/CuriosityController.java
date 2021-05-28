package com.souleaf.spring.curiosity.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.domain.CuriosityReply;
import com.souleaf.spring.curiosity.service.CuriosityService;
import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.plant.domain.Plant;
@Controller
public class CuriosityController {
	@Autowired
	private CuriosityService cService;
	
	// 궁금해요 리스트 페이지 이동 및 출력
	@RequestMapping(value="curiosityListView.kh")
	public ModelAndView curiosityListView(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("nav", "curiosity");
		mv.setViewName("curiosity/curiosityListView");
		return mv;
	}
	
	// 궁금해요 리스트 출력
	@ResponseBody
	@RequestMapping(value="curiosityList.kh")
	public void getPlantList(HttpServletResponse response, @RequestParam("current") int current) throws Exception {
		System.out.println(current);
		ArrayList<Curiosity> cList = cService.printAllList();
		if(! cList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(cList, response.getWriter());
		}else {
			System.out.println("데이터가 없습니다");
		}
	}
	
	// 궁금해요 상세페이지 이동 및 출력
	@RequestMapping(value="curiosityDetail.kh")
	public ModelAndView curiosityDetailView(ModelAndView mv,@RequestParam("curiosityNo") int curiosityNo,  Model model) {
		Curiosity curiosity = cService.printOne(curiosityNo);
		if(curiosity != null) {
			mv.addObject("curiosity",curiosity).setViewName("curiosity/curiosityDetail");
		}else {
			
		}
		return mv;
	}
	
	// 궁금해요 등록화면 이동
	@RequestMapping(value="curiosityWrite.kh")
	public String curiosityWriterView() {
		return "curiosity/curiosityWrite";
	}
	
	// 궁금해요 게시글 등록
	@RequestMapping(value="curiosityRegister.kh", method = RequestMethod.POST)
	public ModelAndView curiosityRegister(ModelAndView mv, Curiosity curiosity, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginUser");
		String curiosityFileRename = (String)session.getAttribute("fileName");
		int memberNo = member.getMemberNo();
		curiosity.setMemberNo(memberNo);	
		curiosity.setCuriosityFileRename(curiosityFileRename);
	
		int result = cService.registerCuriosity(curiosity);
		if(result > 0) {
			mv.setViewName("redirect:curiosityListView.kh");
			session.setAttribute("fileName", "");
		}else {
			
		}
		return mv;
	}

	// 궁금해요 수정화면 이동
	@RequestMapping(value="curiosityModifyView.kh")
	public ModelAndView curiosityUpdateView(ModelAndView mv,@RequestParam("curiosityNo") int curiosityNo,@ModelAttribute Curiosity curiosity, Model model) {
		curiosity = cService.printOne(curiosityNo);
		if(curiosity != null) {
			mv.addObject("curiosity",curiosity).setViewName("curiosity/curiosityUpdate");
		}else {
			
		}
		return mv;
	}
	
	// 궁금해요 게시글 수정
	@RequestMapping(value="curiosityModify.kh",method = RequestMethod.POST)
	public ModelAndView curiosityUpdate(ModelAndView mv, Curiosity curiosity, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginUser");
		String curiosityFileRename = (String)session.getAttribute("fileName");
		int memberNo = member.getMemberNo();
		curiosity.setMemberNo(memberNo);	
		curiosity.setCuriosityFileRename(curiosityFileRename);
	
		int result = cService.modifyCuriosity(curiosity);
		if(result > 0) {
			mv.setViewName("redirect:curiosityDetail.kh?curiosityNo="+curiosity.getCuriosityNo());
			session.setAttribute("fileName", "");
		}else {
			
		}
		return mv;
	}
	
	// 궁금해요 게시글 삭제
	public String curiosityDelete(int curiosityNo, Model model, HttpServletRequest request) {
		return "";
	}
	
	// 궁금해요 댓글 리스트 출력
	@ResponseBody
	@RequestMapping(value="curiosityReplyList.kh")
	public void curiosityReplyListView(HttpServletResponse response,@RequestParam("curiosityNo") int curiosityNo, CuriosityReply reply, Model model) throws Exception {
		ArrayList<CuriosityReply> crList = cService.printAllCuriosityReply(curiosityNo);
		if(! crList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
			gson.toJson(crList, response.getWriter());
		}else {
			System.out.println("데이터가 없습니다");
		}
	}
	
	// 궁금해요 댓글 등록
	@ResponseBody
	@RequestMapping(value="curiosityReplyRegister.kh", method = RequestMethod.POST)
	public String curiosityReplyRegister(@ModelAttribute CuriosityReply reply, HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		reply.setMemberNo(loginUser.getMemberNo());
		int result = cService.registerCuriosityReply(reply);
		if(result > 0) {
			return result+"";
		}else {
			return result+"";
		}
	}
	
	// 궁금해요 댓글 수정
	@ResponseBody
	@RequestMapping(value="curiosityReplyModify.kh", method = RequestMethod.POST)
	public String curiosityReplyModify(@ModelAttribute CuriosityReply reply, HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		reply.setMemberNo(loginUser.getMemberNo());
		int result = cService.modifyCuriosityReply(reply);
		if(result > 0) {
			return result+"";
		}else {
			return result+"";
		}
	}
	
	// 궁금해요 댓글 삭제
	public String curiosityReplyDelete(int curiosityNo, Model model) {
		return "";
	}
	
	// 파일 저장
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		// 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/uploadFiles/curiosity";
		// 저장 폴더 선택
		File folder = new File(savePath);
		// 폴더없으면 자동 생성
		if(!folder.exists()) {
			folder.mkdir();
		}
		// 파일명 변경하기 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originalFileName = file.getOriginalFilename();
		// indexof : 왼쪽부터 검색해서 .의 위치를 알려줌 , lastindexof : 오른쪽부터 .의 위치를 알려줌
		// abd.jpg => 확장자명을 가져오기 위해서 사용
		String renameFileName= sdf.format(new Date(System.currentTimeMillis()))+"."+originalFileName.substring(originalFileName.lastIndexOf(".")+1);
		String filePath = folder +"/" + renameFileName;		
		
		// 파일 저장
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
		HttpSession session = request.getSession();
		session.setAttribute("fileName", renameFileName);
		return renameFileName;
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
	
	@ResponseBody
	@RequestMapping(value="summer_image.kh",method = RequestMethod.POST)
	public void summer_image(MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String server_file_name = saveFile(file, request);
		System.out.println("server file : " + server_file_name);
		
		out.println("resources/uploadFiles/curiosity/"+server_file_name);
		out.close();
		
	
	}
  
	
}
