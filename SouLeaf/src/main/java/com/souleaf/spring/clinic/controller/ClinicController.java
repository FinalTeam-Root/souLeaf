package com.souleaf.spring.clinic.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.domain.ClinicReply;
import com.souleaf.spring.clinic.service.ClinicService;
import com.souleaf.spring.common.ClinicPagination;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.plant.domain.Plant;

@Controller
public class ClinicController {
	@Autowired
	private ClinicService cService;
	
	// 클리닉 리스트 페이지 이동 및 출력
	@RequestMapping(value="clinicListView.kh")
	public ModelAndView clinicListView(ModelAndView mv,@RequestParam(value = "page", required = false) Integer page ,@RequestParam(value = "count", required = false) Integer count, HttpServletRequest request) {
		int currentPage = (page != null) ? page : 1;
		int currentCount = (count != null) ? count : 0;
		HttpSession session = request.getSession();
		session.setAttribute("nav", "clinic");
		session.setAttribute("fileName", "");
		mv.addObject("page",currentPage).addObject("count",currentCount).setViewName("clinic/clinicListView");
		return mv;
	}
	
	// 궁금해요 리스트 출력
	@RequestMapping(value="clinicList.kh")
	public void getCuriosityList(HttpServletResponse response, @RequestParam(value = "page", required = false) Integer page) throws Exception {
		int currentPage = (page != null) ? page : 1;
		int listCount = cService.getClinicListCount();
		PageInfo pi = ClinicPagination.getPageInfo(currentPage, listCount);
		ArrayList<Clinic> cList = cService.printAllList(pi);
		if(! cList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(cList, response.getWriter());
		}else {
			System.out.println("데이터가 없습니다");
		}
	}
	
	// 궁금해요 페이지 출력
	@RequestMapping(value="clinicPage.kh")
	public void getClinicPage(HttpServletResponse response, @RequestParam(value = "page", required = false) Integer page) throws Exception  {
		int currentPage = (page != null) ? page : 1;
		int listCount = cService.getClinicListCount();
		PageInfo pi = ClinicPagination.getPageInfo(currentPage, listCount);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(pi, response.getWriter());
	}
	
	// 궁금해요 상세페이지 이동 및 출력
	@RequestMapping(value="clinicDetail.kh")
	public ModelAndView clinicDetailView(ModelAndView mv,@RequestParam("clinicNo") int clinicNo, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "count", required = false) Integer count, Model model) {
		int currentPage = (page != null) ? page : 1;
		int currentCount = (count != null) ? count : 0;
		cService.addViewCount(clinicNo);
		Clinic clinic = cService.printOne(clinicNo);
		if(clinic != null) {
			mv.addObject("page",currentPage).addObject("count",currentCount).addObject("clinic",clinic).setViewName("clinic/clinicDetail");
		}else {
			
		}
		return mv;
	}
	
	// 궁금해요 등록화면 이동
	@RequestMapping(value="clinicWrite.kh")
	public String clinicWriterView() {
		return "clinic/clinicWrite";
	}
	
	// 궁금해요 게시글 등록
	@RequestMapping(value="clinicRegister.kh", method = RequestMethod.POST)
	public ModelAndView clinicRegister(ModelAndView mv, Clinic clinic, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginUser");
		String clinicFileRename = (String)session.getAttribute("fileName");
		int memberNo = member.getMemberNo();
		clinic.setMemberNo(memberNo);	
		clinic.setClinicFileRename(clinicFileRename);
	
		int result = cService.registerClinic(clinic);
		if(result > 0) {
			mv.setViewName("redirect:clinicListView.kh");
			session.setAttribute("fileName", "");
		}else {
			
		}
		return mv;
	}

	// 궁금해요 수정화면 이동
	@RequestMapping(value="clinicModifyView.kh")
	public ModelAndView clinicUpdateView(ModelAndView mv,@RequestParam("clinicNo") int clinicNo,@ModelAttribute Clinic clinic, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "count", required = false) Integer count, Model model) {
		int currentPage = (page != null) ? page : 1;
		int currentCount = (count != null) ? count : 0;
		clinic = cService.printOne(clinicNo);
		if(clinic != null) {
			mv.addObject("page",currentPage).addObject("count",currentCount).addObject("clinic",clinic).setViewName("clinic/clinicUpdate");
		}else {
			
		}
		return mv;
	}
	
	// 궁금해요 게시글 수정
	@RequestMapping(value="clinicModify.kh",method = RequestMethod.POST)
	public ModelAndView clinicUpdate(ModelAndView mv, Clinic clinic, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "count", required = false) Integer count, Model model, HttpServletRequest request) {
		int currentPage = (page != null) ? page : 1;
		int currentCount = (count != null) ? count : 0;
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginUser");
		String clinicFileRename = (String)session.getAttribute("fileName");
		int memberNo = member.getMemberNo();
		clinic.setMemberNo(memberNo);	
		clinic.setClinicFileRename(clinicFileRename);
	
		int result = cService.modifyClinic(clinic);
		if(result > 0) {
			mv.setViewName("redirect:clinicDetail.kh?clinicNo="+clinic.getClinicNo()+"&page="+currentPage+"&count="+currentCount);
			session.setAttribute("fileName", "");
		}else {
			
		}
		return mv;
	}
	
	// 궁금해요 게시글 삭제
	public String clinicDelete(int clinicNo, Model model, HttpServletRequest request) {
		return "";
	}
	
	// 궁금해요 댓글 리스트 출력
	@RequestMapping(value="clinicReplyList.kh")
	public void clinicReplyListView(HttpServletResponse response,@RequestParam("clinicNo") int clinicNo, ClinicReply reply, Model model) throws Exception {
		ArrayList<ClinicReply> crList = cService.printAllClinicReply(clinicNo);
		if(! crList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
			gson.toJson(crList, response.getWriter());
		}else {
			System.out.println("데이터가 없습니다");
		}
	}
	
	// 궁금해요 댓글 등록
	@ResponseBody
	@RequestMapping(value="clinicReplyRegister.kh", method = RequestMethod.POST)
	public String clinicReplyRegister(@ModelAttribute ClinicReply reply, HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		reply.setMemberNo(loginUser.getMemberNo());
		int result = cService.registerClinicReply(reply);
		if(result > 0) {
			return result+"";
		}else {
			return result+"";
		}
	}
	
	// 궁금해요 댓글 수정
	@ResponseBody
	@RequestMapping(value="clinicReplyModify.kh", method = RequestMethod.POST)
	public String clinicReplyModify(@ModelAttribute ClinicReply reply, HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		reply.setMemberNo(loginUser.getMemberNo());
		int result = cService.modifyClinicReply(reply);
		if(result > 0) {
			return result+"";
		}else {
			return result+"";
		}
	}
	
	// 궁금해요 댓글 삭제
	public String clinicReplyDelete(int clinicNo, Model model) {
		return "";
	}
	
	// 파일 저장
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		// 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/uploadFiles/clinic";
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
	public ModelAndView clinicAddCount(ModelAndView mv, int clinicNo, Model model) {
		return null;
	}
	
	// 해시태그 출력
	public String getHashTagList(Plant plant, Model model) {
		return "";
	}
	
	@ResponseBody
	@RequestMapping(value="clinic_image.kh",method = RequestMethod.POST)
	public void clinic_image(MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String server_file_name = saveFile(file, request);
		System.out.println("server file : " + server_file_name);
		
		out.println("resources/uploadFiles/clinic/"+server_file_name);
		out.close();
	
	}
}