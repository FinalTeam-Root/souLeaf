package com.souleaf.spring.mypage.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.souleaf.spring.boast.service.BoastService;
import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.service.ClinicService;
import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.service.CuriosityService;
import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.member.service.MemberService;
import com.souleaf.spring.mypage.domain.MypageInfo;
import com.souleaf.spring.mypage.domain.MypagePagination;
import com.souleaf.spring.mypage.domain.MypageSearch;
import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.service.PlantService;

@Controller
public class MypageController {
	@Autowired
	private PlantService pService;
	@Autowired
	private MemberService memService;
	
//	@Autowired
//	private BoastService bService;
//	
	@Autowired
	private ClinicService cliService;
	
	@Autowired
	private CuriosityService curService;
	
	// 마이페이지 뷰
	@RequestMapping(value = "mypage.kh", method = RequestMethod.GET)
	public ModelAndView myPageView(ModelAndView mv, HttpSession session, HttpServletRequest request ) {
		session = request.getSession();
		session.setAttribute("nav", "my");
		Member loginUser = (Member) session.getAttribute("loginUser");
		ArrayList<Plant> pList = pService.printMemberCompanion(loginUser.getMemberNo());
		loginUser = memService.printMember(loginUser.getMemberNo());
		mv.addObject("pList", pList);
		mv.addObject("loginUser", loginUser).setViewName("mypage/myPage");
		return mv;
		
	}
	
	
	// 마이페이지 내 게시글관리 뷰
	@RequestMapping(value="mypageBoard.kh")
	public String mypageBoard() {
		return "mypage/mypageBoard";
	}
	
	
	// 궁금해요 리스트 가져오기
	@RequestMapping(value="myCuriosityList.kh")
	public void getMyCuriosityList(HttpServletResponse response, HttpServletRequest request, @RequestParam(value="page", required=false) Integer page, HttpSession session) throws Exception{
		session.setAttribute("fileName","");
		int memberNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
		int currentPage = (page != null) ? page : 1;
		int listCount = curService.getMyCuriosityListCount(memberNo);
		MypageInfo pi = MypagePagination.getPageInfo(currentPage, listCount);
		ArrayList<Curiosity> curList = curService.printAllMyCuriosity(memberNo,pi);
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("pi", pi);
		map.put("curList", curList);
		if(!curList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(map,response.getWriter());
		}else {
			System.out.println("궁금해요 리스트 없다! 어쩔래?");
		}
		
	}
	
	// 궁금해요 검색
	@RequestMapping(value="curiositySearch.kh")
	public void curiositySearch(@ModelAttribute MypageSearch search, HttpServletRequest request,  HttpServletResponse response,@RequestParam(value="page", required=false) Integer page) throws Exception {
		HttpSession session = request.getSession();
		int memberNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
		int currentPage = (page != null) ? page : 1;
		search.setMemberNo(memberNo);
		int listCount = curService.getMySearchCount(search);
		MypageInfo pi = MypagePagination.getPageInfo(currentPage, listCount);
		ArrayList<Curiosity> searchList = curService.printSearchAllList(search,pi);
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("pi", pi);
		map.put("searchList", searchList);
		map.put("pageSearch", search);
		if(!searchList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(map, response.getWriter());
		}else {
			System.out.println("궁금해요 검색 결과없어 임마 돌아가");
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(map,response.getWriter());
		}
	}
	
	// 궁금해요 리스트 선택 삭제
	@ResponseBody
	@RequestMapping(value="curiositydelete.kh" ,method = RequestMethod.GET)
	public String curiositydelete(@RequestParam String chkNo ) {
		System.out.println(chkNo);
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("chkNo", chkNo);
		int result = curService.removeMyCuriosity(map);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
//  내가 한 그지같은 코드	
//	@ResponseBody
//	@RequestMapping(value="curiositydelete.kh" ,method = RequestMethod.GET)
//	public String curiositydelete(Map<String,Object> map) {
//		int cnt = Integer.parseInt((String) map.get("cnt"));
//		int result = 0;
//		String arr = (String)map.get("arr");
//		String [] strArray = arr.split(",");
//		for(int i=0; i<cnt;i++) {
//			System.out.println(strArray);
//			int temp = Integer.parseInt((String)strArray[i]);
//			map.put("arr",temp);
//			result = curService.removeMyCuriosity(map);
//		}
//		if(result > 0) {
//			return "success";
//		}else {
//			return "fail";
//		}
//	}
	
	
	//  클리닉 게시글 가져오기
	@RequestMapping(value="myClinicList.kh")
	public void getMyClinicList(HttpServletResponse response, HttpServletRequest request, @RequestParam(value="page", required=false) Integer page, HttpSession session) throws Exception{
		session.setAttribute("fileName","");
		int memberNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
		int currentPage = (page != null) ? page : 1;
		int listCount = cliService.getMyClinicListCount(memberNo);
		MypageInfo pi = MypagePagination.getPageInfo(currentPage, listCount);
		ArrayList<Clinic> cliList = cliService.printAllMyClinic(memberNo,pi);
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("pi", pi);
		map.put("cliList", cliList);
		if(!cliList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(map,response.getWriter());
		}else {
			System.out.println("클리닉 리스트 없다! 어쩔래?");
		}
		
	}
	
	// 궁금해요 검색
	@RequestMapping(value="clinicSearch.kh")
	public void clinicSearch(@ModelAttribute MypageSearch search, HttpServletRequest request,  HttpServletResponse response,@RequestParam(value="page", required=false) Integer page) throws Exception {
		HttpSession session = request.getSession();
		int memberNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
		int currentPage = (page != null) ? page : 1;
		search.setMemberNo(memberNo);
		int listCount = cliService.getMySearchCount(search);
		MypageInfo pi = MypagePagination.getPageInfo(currentPage, listCount);
		ArrayList<Clinic> searchList = cliService.printSearchAllList(search,pi);
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("pi", pi);
		map.put("searchList", searchList);
		map.put("pageSearch", search);
		if(!searchList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(map, response.getWriter());
		}else {
			System.out.println("궁금해요 검색 결과없어 임마 돌아가");
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(map,response.getWriter());
		}
	}
		
	// 궁금해요 리스트 선택 삭제
	@ResponseBody
	@RequestMapping(value="clinicdelete.kh" ,method = RequestMethod.GET)
	public String clinicdelete(@RequestParam String chkNo ) {
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("chkNo", chkNo);
		int result = cliService.removeMyClinic(map);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	// 패스워트 변경 페이지로 이동
	@RequestMapping(value="changPwView.kh", method=RequestMethod.GET)
	public String changPwView() {
		return "mypage/changePassword";
	}
	

}
