package com.souleaf.spring.clinic.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

import com.souleaf.spring.clinic.domain.Clinic;
import com.souleaf.spring.clinic.service.ClinicService;
import com.souleaf.spring.common.PageInfo;
import com.souleaf.spring.common.Pagination;

//@Controller
public class ClinicController {

//	@Autowired
	private ClinicService cService;

	/**
	 * 클리닉게시물을 가져오는 메소드
	 * @author ohwoocheol
	 * @since 2021.8.15
	 * @param mv
	 * @param page
	 * @return clinicListView.jsp
	 */
//	@RequestMapping(value="clinicList.kh", method=RequestMethod.GET)
	public ModelAndView ClinicListView(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page) {

		// 삼항연산자 「page」가 「null」 이 아니면 currentPage에 「page」 대입 「null」이면 currentPage에 「1」 대입
		int currentPage = (page != null) ? page : 1;
		// 클리닉 게시물 개수 조회
		int listCount = cService.getListCount();
		// 페이지 정보 취득
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		// 페이지 정보를 이용한 클리닉 게시믈 취득
		ArrayList<Clinic> clinicList = cService.printAll(pi);
		if (!clinicList.isEmpty()) {
			mv.addObject("bList", clinicList);
			mv.addObject("pi", pi);
			// clinicListView.jsp
			mv.setViewName("clinic/clinicListView");
		} else {
			mv.addObject("msg", "클리닉 전체조회 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	

	/**
	 * 클리닉 상세화면
	 * @author ohwoocheol
	 * @since 2021.8.15
	 * @param mv
	 * @param boardNo
	 * @return clinicDetailView.jsp
	 */
//	@RequestMapping(value = "clinicDetail.kh", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView boardDetail(ModelAndView mv, @RequestParam("clinicNo") int clinicNo) {
		// 조회수 증가
		cService.addReadCount(clinicNo);

		// 게시글 상세 조회
		Clinic clinic = cService.printOne(clinicNo);
		if (clinic != null) {
			// 메소드 체이닝 방식
			mv.addObject("clinic", clinic).setViewName("clinic/clinicDetailView");
		} else {
			mv.addObject("msg", "클리닉 상세 조회 실패!");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}

//	// 게시글 등록화면
//	@RequestMapping(value = "clinicWriteView.kh", method = RequestMethod.GET)
//	public String boardWriteView() {
//		return "clinic/clinicWriteForm";
//	}
//
//	// 게시글 등록
//	@RequestMapping(value = "boardRegister.kh", method = RequestMethod.POST)
//	public ModelAndView boardRegister(ModelAndView mv, @ModelAttribute Clinic board,
//			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile,
//			HttpServletRequest request) {
//		// 서버에 파일을 저장하는 작업
//		// MultipartFile 이란, 스프링에서 제공하는 인터페이스 (파일 업로드 처리)
//		// !uploadFile(업로드한 파일의) getOriginalFilename (파일이름이). equals("") 공백이아니냐
//		if (!uploadFile.getOriginalFilename().equals("")) { // 파일 이름이 공백("")이 아니라면 saveFile 메소드 호출
//			String renameFileName = saveFile(uploadFile, request);
//			// 그래서 여기 서는 파일이름도 바꿔주고 지정한 경로에 저장도 했지
//			if (renameFileName != null) {
//				// 그래서 오리지널파일명도 set해주고 새로운 파일명도 set 해주고
//				board.setOriginalFilename(uploadFile.getOriginalFilename());
//				board.setRenameFilename(renameFileName);
//			}
//		}
//		// 디비에 데이터를 저장하는 작업
//		int result = 0;
//		String path = "";
//		result = cService.registerBoard(board);
//		if (result > 0) {
//			path = "redirect:boardList.kh";
//		} else {
//			mv.addObject("msg", "게시글 등록 실패");
//			path = "common/errorPage";
//		}
//		mv.setViewName(path);
//		return mv;
//	}
//
//	// 파일정보랑 request 값이 파라미터
//	public String saveFile(MultipartFile file, HttpServletRequest request) {
//		// 파일 저장 경로 설정
//		// request.getSession() 웹의 / getServletContext 경로를 가져올거야 / resources 여기를
//		// getRealPath("/"); 이렇게만 쓰면 src/main/webapp .getRealPath("resources");를 적음으로서
//		// src/main/webapp/resources 이 경로가 root 로 들어가는거야
//		// 즉, 수정 또는 새롭게 추가된 파일이 저장될 경로 얻어서 최종적으로 savePath 에 담아준다
//		String root = request.getSession().getServletContext().getRealPath("resources");
//		String savePath = root + "\\buploadFiles";
//		// 아래처럼 한번에 쓸 수 있음
//		// String savePath1 =
//		// request.getSession().getServletContext().getRealPath("resources") +
//		// "\\buploadFiles";
//
//		// 저장 폴더 선택
//		// File 클래스는 입출력에 필요한 파일 및 디렉토리에 관한 정보를 다룰 수 있어
//		// File 변수 = new File(경로);
//		File folder = new File(savePath);
//		// 폴더없으면 자동 생성
//		// File 클래스에 지정된 기능
//		// exists()는 해당 파일의 파일 경로의 파일 또는 디렉토리의 존재 여부 확인.
//		// mkdir()은 파일시스템 경로에 디렉토리를 생성한다.(폴더생성 or 파일생성 (같은말인데 이해하기 쉬우라고))
//		if (!folder.exists()) {
//			folder.mkdir();
//		}
//		// 파일명 변경하기
//		// SimpleDateFormat 으로 데이터 포멧 결정 yyyy년 MM월 dd일 HH시 mm분 ss초
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//		// MultipartFile클래스의 getOriginalFilename() 메소드 파일명 가져오는 역할을 함 /
//		// originalFileName에 넣어줌 오리지널파일이름
//		String originalFileName = file.getOriginalFilename();
//
//		String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + "."
//				+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
//		// a.bc.jpg
//
//		/**
//		 * // 시스템날짜 (밀리초포함)을 renameFileName에 넣어줄거야 왜냐? 이거를 파일 이름으로 만들거야 String
//		 * renameFileName1 = sdf.format(new Date(System.currentTimeMillis()));
//		 * 
//		 * // 위에서 시스템날짜로 만든 이름에다가 확장자를 붙여줄건데 // renameFileName1 += "." 이것만 보면 「새로운이름.」 을
//		 * 만들어준거고 // originalFileName.lastIndexOf(".")+1 이게 ABC.txt 라면 lastIndexOf .(점)
//		 * 을 기준으로 +1 인덱스부터 가져와 // 즉 txt만 가져오는거야 이게 substring이 뭐야 문자열 자르는 메소드잖아 //
//		 * ABC.txt에서 txt만 잘라서 가져오겠다는거야 renameFileName1 += "." +
//		 * originalFileName.substring(originalFileName.lastIndexOf(".")+1);
//		 */
//
//		// 그래서 최종적으로 파일경로 filePath 에 「파일경로+\\+새로운이름」으로 넣어주고
//		String filePath = folder + "\\" + renameFileName;
//		// 파일저장
//		try {
//			// transferTo가 파일데이터를 지정한 File로 저장하는거야 지정한File은 filePath 이거 겠지
//			file.transferTo(new File(filePath));
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// 리턴
//		return renameFileName;
//	}
//
//	// 게시글 수정화면
//	@RequestMapping(value = "boardModifyView.kh")
//	public ModelAndView boardModifyView(ModelAndView mv, @RequestParam("boardNo") int boardNo) {
//
//		Board board = cService.printOne(boardNo);
//		if (board != null) {
//			mv.addObject("board", board).setViewName("board/boardUpdateView");
//		} else {
//			mv.addObject("msg", "게시글 상제 조회 실패").setViewName("common/errorPage");
//		}
//
//		return mv;
//	}
//
//	@RequestMapping(value = "boardUpdate.kh", method = RequestMethod.POST)
//	public ModelAndView boardUpdate(ModelAndView mv, HttpServletRequest request, @ModelAttribute Board board,
//			@RequestParam(value = "reloadFile", required = false) MultipartFile reloadFile) {
//		// 파일 삭제 후 업로드 ( 수정 )
//		if (reloadFile != null && !reloadFile.isEmpty()) {
//			// 기존 파일 삭제
//			if (board.getOriginalFilename() != "") {
//				deleteFile(board.getRenameFilename(), request);
//			}
//			// 새 파일 업로드
//			String renameFileName = saveFile(reloadFile, request);
//			if (renameFileName != null) {
//				board.setOriginalFilename(reloadFile.getOriginalFilename());
//				board.setRenameFilename(renameFileName);
//			}
//		}
//		// DB 수정
//		int result = cService.modifyBoard(board);
//		if (result > 0) {
//			mv.setViewName("redirect:boardList.kh");
//		} else {
//			mv.addObject("msg", "게시글 수정 실패").setViewName("common/errorPage");
//		}
//		return mv;
//	}
//
//	// 게시글 삭제(실제로는 상태 업데이트)
//	@RequestMapping(value = "boardDelete.kh", method = RequestMethod.GET)
//	public String boardDelete(Model model, @RequestParam("boardNo") int boardNo,
//			@RequestParam("renameFilename") String renameFilename, HttpServletRequest request) {
//		// 업로드된 파일 삭제
//		if (renameFilename != "") {
//			deleteFile(renameFilename, request);
//		}
//
//		// 디비에 데이터 업데이트
//		int result = cService.removeBoard(boardNo);
//		if (result > 0) {
//			return "redirect:boardList.kh";
//		} else {
//			model.addAttribute("msg", "게시글 삭제 실패");
//			return "common/errorPage";
//		}
//	}
//
//	public void deleteFile(String fileName, HttpServletRequest request) {
//		String root = request.getSession().getServletContext().getRealPath("resources");
//		String savePath = root + "\\buploadFiles";
//		File file = new File(savePath + "\\" + fileName);
//		if (file.exists()) {
//			file.delete();
//		}
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "addReply.kh", method = RequestMethod.POST)
//	public String addReply(@ModelAttribute Reply reply, HttpSession session) {
//		Member loginUser = (Member) session.getAttribute("loginUser");
//		reply.setReplyWriter(loginUser.getUserId());
//		int result = cService.registerReply(reply);
//		if (result > 0) {
//			return "success";
//		} else {
//			return "fail";
//		}
//	}
//
//	@RequestMapping(value = "replyList.kh", method = RequestMethod.GET)
//	public void getReplyList(HttpServletResponse response, @RequestParam("boardNo") int boardNo) throws Exception {
//		ArrayList<Reply> rList = cService.printAllReply(boardNo);
//		if (!rList.isEmpty()) {
//			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); // 날짜 포맷 변경!
//			gson.toJson(rList, response.getWriter());
//		} else {
//			System.out.println("데이터가 없습니다.");
//		}
//	}
//	
	
	//------------------------------------------------------------------------------------
//	@RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
//    public String dragAndDrop(Model model) {
//        
//        return "fileUpload";
//        
//    }
//    
//    @RequestMapping(value = "/fileUpload/post") //ajax에서 호출하는 부분
//    @ResponseBody
//    public String upload(MultipartHttpServletRequest multipartRequest) { //Multipart로 받는다.
//        Iterator<String> itr =  multipartRequest.getFileNames();
//        String filePath = "C:/test"; //설정파일로 뺀다.
//        while (itr.hasNext()) { //받은 파일들을 모두 돌린다.
//            MultipartFile mpf = multipartRequest.getFile(itr.next());
//            String originalFilename = mpf.getOriginalFilename(); //파일명
//            String fileFullPath = filePath+"/"+originalFilename; //파일 전체 경로
//            try {
//                //파일 저장
//                mpf.transferTo(new File(fileFullPath)); //파일저장 실제로는 service에서 처리
//                System.out.println("originalFilename => "+originalFilename);
//                System.out.println("fileFullPath => "+fileFullPath);
//            } catch (Exception e) {
//                System.out.println("postTempFile_ERROR======>"+fileFullPath);
//                e.printStackTrace();
//            }
//       }
//        return "success";
//    }
}
