package com.souleaf.spring.boast.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.souleaf.spring.boast.domain.Boast;
import com.souleaf.spring.boast.domain.BoastReply;
import com.souleaf.spring.boast.service.BoastService;
import com.souleaf.spring.common.BoastPagination;
import com.souleaf.spring.common.CuriosityPagination;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.common.Pagination;
import com.souleaf.spring.curiosity.domain.Curiosity;
import com.souleaf.spring.curiosity.domain.CuriosityReply;
import com.souleaf.spring.member.domain.Member;

@Controller
public class BoastController {

	@Autowired
	private BoastService bService;

	// 자랑하기 리스트 페이지 이동 및 출력 //////////
	@RequestMapping(value = "boastListView.kh", method = RequestMethod.GET)
	public ModelAndView boastListView(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("nav", "boast");
		int currentPage = (page != null) ? page : 1;
		int listCount = bService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<Boast> bList = bService.printAll(pi);
		System.out.println("들어왔니?");
		if (!bList.isEmpty()) {
			mv.addObject("bList", bList);
			mv.addObject("pi", pi);
			mv.setViewName("Boast/boastListView");

		} else {
			mv.addObject("msg", "게시글 전체조회 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}

	// 자랑하기 리스트 출력
		@RequestMapping(value="boastList.kh")
		public void getBoastList(HttpServletResponse response, @RequestParam(value = "page", required = false) Integer page) throws Exception {
			int currentPage = (page != null) ? page : 1;
			int listCount = bService.getListCount();
			PageInfo pi = BoastPagination.getPageInfo(currentPage, listCount);
			ArrayList<Boast> bList = bService.printAll(pi);
			if(! bList.isEmpty()) {
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
				gson.toJson(bList, response.getWriter());
			}else {
				System.out.println("데이터가 없습니다");
			}
		}
	
	// 자랑하기 페이지 출력
	@RequestMapping(value="boastPage.kh")
	public void getBoastPage(HttpServletResponse response, @RequestParam(value = "page", required = false) Integer page) throws Exception  {
		int currentPage = (page != null) ? page : 1;
		int listCount = bService.getListCount();
		PageInfo pi = BoastPagination.getPageInfo(currentPage, listCount);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(pi, response.getWriter());
	}
	
	// 자랑하기 상세페이지 이동 및 출력////////////
	@RequestMapping(value = "boastDetail.kh", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView boastDetailView(ModelAndView mv, @RequestParam("boastNo") int boastNo) {
		// 조회수 증가
		bService.addReadCount(boastNo);

		// 게시글 상세 조회
		Boast boast = bService.printOne(boastNo);
		if (boast != null) {
			// 메소드 체이닝 방식
			mv.addObject("boast", boast).setViewName("Boast/boastDetailView"); // 대소문자
		} else {
			mv.addObject("msg", "게시글 상세 조회 실패!!!!!!!!!!!!!");
			mv.setViewName("common/errorPage");
		}
		return mv;

	}

	// 자랑하기 등록화면 이동
	@RequestMapping(value = "boastWrite.kh") // 매핑 잘 확인하기
	public String boastWriterView() {
		return "Boast/boastWriteForm"; // 대소문자 확인 잘하기
	}

	// 자랑하기 게시글 등록
	@RequestMapping(value = "boastWrite.kh", method = RequestMethod.POST)
	public ModelAndView boastRegister(ModelAndView mv, @ModelAttribute Boast boast,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser");
		int memberNo = member.getMemberNo();
		boast.setMemberNo(memberNo);
		
		// 서버에 파일을 저장하는 작업

		if (!uploadFile.getOriginalFilename().equals("")) {
			String renameFileName = saveFile(uploadFile, request);
			System.out.println("들어왔니");
			if (renameFileName != null) {
				boast.setBoastFileName(uploadFile.getOriginalFilename());
				boast.setBoastReName(renameFileName);

				System.out.println("들어왔니");
			}
		} // 디비에 데이터를 저장하는 작업
		System.out.println("들어왔니");
		int result = 0;
		String path = "";
		result = bService.registerBoast(boast);
		if (result > 0) {
			path = "redirect:boastListView.kh";
		} else {
			mv.addObject("msg", "게시글 등록 실패");
			path = "common/errorPage";
		}
		mv.setViewName(path);
		return mv;
	}

	// 자랑하기 수정화면 이동

	
	// 자랑하기 수정화면 이동 2

	/*
	 * @RequestMapping(value="boastUpdate.kh") public ModelAndView
	 * boastUpdateView(ModelAndView mv,@RequestParam("boastNo") int
	 * boastNo,@ModelAttribute Boast boast, @RequestParam(value = "page", required =
	 * false) Integer page, @RequestParam(value = "count", required = false) Integer
	 * count, Model model) { int currentPage = (page != null) ? page : 1; int
	 * currentCount = (count != null) ? count : 0; boast =
	 * bService.printOne(boastNo); if(boast != null) {
	 * mv.addObject("page",currentPage).addObject("count",currentCount).addObject(
	 * "boast",boast).setViewName("Boast/boastUpdateView"); }else {
	 * 
	 * } return mv; }
	 */

	// 자랑하기 게시글 수정 1
	/*
	 * @RequestMapping(value = "boastUpdate.kh", method = RequestMethod.POST) public
	 * ModelAndView boastUpdate(ModelAndView mv, @ModelAttribute Boast boast,
	 * MultipartHttpServletRequest multipartRequest, HttpServletRequest request,
	 * Model model) { List<MultipartFile> bList =
	 * multipartRequest.getFiles("ufile"); String root =
	 * request.getSession().getServletContext().getRealPath("resources");
	 * 
	 * String filePath = root + "/uploadFiles/boast"; // 설정파일로 뺀다. File folder = new
	 * File(filePath); if (!folder.exists()) { folder.mkdir(); } int result =
	 * bService.modifyBoast(boast);
	 * 
	 * if (result > 0) { mv.setViewName("redirect:boastListView.kh"); } else {
	 * mv.setViewName("common/errorPage"); } return mv; }
	 */
	
	
	// 자랑하기 게시글 수정 2
		@RequestMapping(value="boastUpdate.kh",method = RequestMethod.POST)
		public ModelAndView boastUpdate(ModelAndView mv, Boast boast, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "count", required = false) Integer count, Model model, HttpServletRequest request) {
			int currentPage = (page != null) ? page : 1;
			int currentCount = (count != null) ? count : 0;
			HttpSession session = request.getSession();
			Member member = (Member)session.getAttribute("loginUser");
			
			int memberNo = member.getMemberNo();
			boast.setMemberNo(memberNo);	
			
		System.out.println(boast.toString());
			int result = bService.modifyBoast(boast);
			System.out.println(result);
			if(result > 0) {
				mv.setViewName("redirect:boastDetail.kh?boastNo="+boast.getBoastNo()+"&page="+currentPage+"&count="+currentCount);
				session.setAttribute("fileName", "");
			}else {
				
			}
			return mv;
		}
	
	// 자랑하기 수정화면 이동
	@RequestMapping(value= "boastUpdateView.kh")
	public ModelAndView boastUpdateView(ModelAndView mv,@RequestParam("boastNo") int boastNo,@ModelAttribute Boast boast, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "count", required = false) Integer count, Model model) {
		int currentPage = (page != null) ? page : 1;
		int currentCount = (count != null) ? count : 0;
		boast = bService.printOne(boastNo);
		if(boast != null) {
			mv.addObject("page",currentPage).addObject("count",currentCount).addObject("boast",boast).setViewName("Boast/boastUpdateView");
		}else {
			
		}
		return mv;
	}

	// 자랑하기 게시글 삭제
	@RequestMapping(value = "boastDelete.kh", method = RequestMethod.POST)
	public String boastDelete(@RequestParam("boastNo") int boastNo, Model model,
			@RequestParam("renameFilename") String renameFilename, HttpServletRequest request) {

// 업로드된 파일 삭제
		if (renameFilename != "") {
			deleteFile(renameFilename, request);
		}

// 디비에 데이터 업데이트
		int result = bService.removeBoast(boastNo);
		if (result > 0) {
			return "redirect:boastListView.kh";
		} else {
			model.addAttribute("msg", "게시글 삭제 실패");

			return "common/errorPage";
		}
	}

	// 자랑하기 댓글 리스트 출력
	@ResponseBody
	@RequestMapping(value="boastReplyList.kh")
	public void boastReplyListView(HttpServletResponse response,@RequestParam("boastNo") int boastNo, BoastReply reply, Model model) throws Exception {
		ArrayList<BoastReply> brList = bService.printAllBoastReply(boastNo);
		if(! brList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
			gson.toJson(brList, response.getWriter());
		}else {
			System.out.println("데이터가 없습니다");
		}
	}
	

	// 자랑하기 댓글 등록
	
	  @ResponseBody
	  
	  @RequestMapping(value="boastReplyRegister.kh", method = RequestMethod.POST)
	  public String boastReplyRegister(@ModelAttribute BoastReply reply,
	  HttpSession session) { Member loginUser =
	  (Member)session.getAttribute("loginUser");
	  reply.setMemberNo(loginUser.getMemberNo()); int result =
	  bService.registerBoastReply(reply); if(result > 0) { return result+""; }else
	  { return result+""; } }
	 
	
	
	/*
	 * public ModelAndView boastReplyRegister(ModelAndView mv, int boastNo,
	 * BoastReply reply, MultipartFile uploadFile, Model model) { return null; }
	 */
	// 자랑하기 댓글 수정
	  @ResponseBody
	  @RequestMapping(value="boastReplyModify.kh", method = RequestMethod.POST)
		public String boastReplyModify(@ModelAttribute BoastReply reply, HttpSession session) {
			Member loginUser = (Member)session.getAttribute("loginUser");
			reply.setMemberNo(loginUser.getMemberNo());
			int result = bService.modifyBoastReply(reply);
			if(result > 0) {
				return result+"";
			}else {
				return result+"";
			}
		}
		
	  
	//public ModelAndView boastReplyUpdate(ModelAndView mv, int boastNo, BoastReply reply, MultipartFile uploadFile,
	//		Model model) {
	//	return null;

	//}

	// 자랑하기 댓글 삭제
	public String boastReplyDelete(int boastNo, Model model) {
		return "";
	}

	// 파일 저장
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		// 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/uploadFiles/boast";
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
		HttpSession session = request.getSession();
		session.setAttribute("fileName", renameFileName);
		return renameFileName;

	}

	// 저장된 파일 삭제
	public void deleteFile(String fileName, HttpServletRequest request) {

	}

	// 자랑하기 조회수 증가

	public ModelAndView boastAddReadCount(ModelAndView mv, int boastNo, Model model) {
		return null;
	}

	// 해시태그 출력
	public String getHashTagList(Boast boast, Model model) {
		return "";
	}

	// 자랑하기 좋아요 증가
	public ModelAndView boastLikeNo(ModelAndView mv, int boastNo, Model model) {
		return null;
	}

	// 자랑하기 대댓글 등록

	// 자랑하기 대댓글 수정

	// 자랑하기 대댓글 삭제
}