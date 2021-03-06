package com.souleaf.spring.mypage.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.service.BoastService;
import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.service.ClinicService;
import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.service.CuriosityService;
import com.souleaf.spring.member.domain.Member;
import com.souleaf.spring.member.service.MemberService;
import com.souleaf.spring.mypage.domain.MyReply;
import com.souleaf.spring.mypage.domain.MypageInfo;
import com.souleaf.spring.mypage.domain.MypagePagination;
import com.souleaf.spring.mypage.domain.MypageSearch;
import com.souleaf.spring.mypage.service.MypageService;
import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.service.PlantService;
import com.souleaf.spring.qna.domain.Qna;
import com.souleaf.spring.qna.service.QnaService;
import com.souleaf.spring.security.service.MemberSha256;

@Controller
public class MypageController {
	@Autowired
	private PlantService pService;
	@Autowired
	private MemberService memService;
	
	@Autowired
	private BoastService bService;
	
	@Autowired
	private ClinicService cliService;
	
	@Autowired
	private CuriosityService curService;
	@Autowired
	private MypageService myService;
	
	@Autowired
	private QnaService qService;
	
	// ??????????????? ???
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
	
	
	// ??????????????? ??? ??????????????? ???
	@RequestMapping(value="mypageBoard.kh")
	public String mypageBoard() {
		return "mypage/mypageBoard";
	}
	
	
	// ???????????? ????????? ????????????
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
			System.out.println("???????????? ????????? ??????! ??????????");
		}
		
	}
	
	// ???????????? ??????
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
			System.out.println("???????????? ?????? ???????????? ?????? ?????????");
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(map,response.getWriter());
		}
	}
	
	// ???????????? ????????? ?????? ??????
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
	
//  ?????? ??? ???????????? ??????	
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
	
	
	//  ????????? ????????? ????????????
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
			System.out.println("????????? ????????? ??????! ??????????");
		}
		
	}
	
	// ????????? ??????
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
			System.out.println("???????????? ?????? ???????????? ?????? ?????????");
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(map,response.getWriter());
		}
	}
		
	// ????????? ????????? ?????? ??????
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
	
	// ???????????? ?????? ???????????? ??????
	@RequestMapping(value="changPwView.kh", method=RequestMethod.GET)
	public String changPwView() {
		return "mypage/changePassword";
	}
	
	// ???????????? ?????? ??????
	@RequestMapping(value="changePw.kh" ,method=RequestMethod.POST)
	public void chagnePw(HttpServletResponse response,@ModelAttribute Member member, @RequestParam("newMemberPw") String newMemberPw) throws Exception {
		Member checkMember = memService.checkMemberInfo(member.getMemberId()); 
		String originalPw = checkMember.getMemberPw();  // ????????? ?????? ???????????? ????????????
		String enterPw = MemberSha256.encrypt(newMemberPw); // ?????? ????????? ?????? ?????? ????????? ??????
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(!originalPw.equals(originalPw)) {
			out.println("<script>alert('????????? ??????????????? ????????????. ?????? ??????????????????.');document.location.href='changPwView.kh';</script>");
			out.flush();
		} else {
			checkMember.setMemberPw(enterPw);
			int result = memService.modifyPw(checkMember);
			out.println("<script>document.location.href='mypage.kh';</script>");
			out.flush();
		}
	
		
	}
	
	// ??????????????? ??? ???????????? ???
	@RequestMapping(value="mypageReply.kh")
	public String mypageReply(HttpSession session, Model model) {
		Member member = (Member)session.getAttribute("loginUser");
		int memberNo = member.getMemberNo();
		ArrayList<MyReply> myList = myService.printAllMyReply(memberNo);
		if(! myList.isEmpty()) {
			model.addAttribute("myList",myList);
			return "mypage/mypageReply";
		}
		return "mypage/mypageReply";
	}
	
	
	//  ???????????? ????????? ????????????
	@RequestMapping(value="myQnaList.kh")
	public void getMyQnaList(HttpServletResponse response, HttpServletRequest request, @RequestParam(value="page", required=false) Integer page, HttpSession session) throws Exception{
		session.setAttribute("fileName","");
		int memberNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
		int currentPage = (page != null) ? page : 1;
		int listCount = qService.getMyQnaListCount(memberNo);
		MypageInfo pi = MypagePagination.getPageInfo(currentPage, listCount);
		ArrayList<Qna> qnaList = qService.printAllMyQna(memberNo,pi);
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("pi", pi);
		map.put("qnaList", qnaList);
		if(!qnaList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(map,response.getWriter());
		}else {
			System.out.println("QnA ????????? ??????! ??????????");
		}
		
	}
	
	// ???????????? ????????? ????????????
	@RequestMapping(value="myBoastList.kh")
	public void getMyBoastList(HttpServletResponse response, HttpServletRequest request, @RequestParam(value="page", required=false) Integer page, HttpSession session) throws Exception{
		session.setAttribute("fileName","");
		int memberNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
		int currentPage = (page != null) ? page : 1;
		int listCount = bService.getMyBoastListCount(memberNo);
		MypageInfo pi = MypagePagination.getPageInfo(currentPage, listCount);
		ArrayList<Boast> bList = bService.printAllMyBoast(memberNo,pi);
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("pi", pi);
		map.put("bList", bList);
		if(!bList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(map,response.getWriter());
		}else {
			System.out.println("???????????? ????????? ??????! ??????????");
		}
		
	}
	
	// ???????????? ??????
	@RequestMapping(value="boastSearch.kh")
	public void BoastSearch(@ModelAttribute MypageSearch search, HttpServletRequest request,  HttpServletResponse response,@RequestParam(value="page", required=false) Integer page) throws Exception {
		HttpSession session = request.getSession();
		int memberNo = ((Member)session.getAttribute("loginUser")).getMemberNo();
		int currentPage = (page != null) ? page : 1;
		search.setMemberNo(memberNo);
		int listCount = bService.getMySearchCount(search);
		MypageInfo pi = MypagePagination.getPageInfo(currentPage, listCount);
		ArrayList<Boast> searchList = bService.printSearchAllList(search,pi);
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("pi", pi);
		map.put("searchList", searchList);
		map.put("pageSearch", search);
		if(!searchList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(map, response.getWriter());
		}else {
			System.out.println("???????????? ?????? ???????????? ?????? ?????????");
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(map,response.getWriter());
		}
	}
	
	// ???????????? ????????? ?????? ??????
	@ResponseBody
	@RequestMapping(value="boastdelete.kh" ,method = RequestMethod.GET)
	public String boastdelete(@RequestParam String chkNo ) {
		System.out.println(chkNo);
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("chkNo", chkNo);
		int result = bService.removeMyBoast(map);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
}