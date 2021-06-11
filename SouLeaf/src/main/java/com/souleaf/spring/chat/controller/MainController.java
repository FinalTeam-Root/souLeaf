package com.souleaf.spring.chat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.souleaf.spring.chat.room.Chat;
import com.souleaf.spring.chat.room.Room;
import com.souleaf.spring.chat.service.ChatService;
import com.souleaf.spring.companion.controller.CompanionController;
import com.souleaf.spring.member.domain.Member;

@Controller
public class MainController {

	@Autowired
	private ChatService cService;

	private Logger log = LoggerFactory.getLogger(CompanionController.class);

	List<Room> roomList = new ArrayList<Room>();
	static int roomNumber = 0;

	/**
	 * 채팅 화면 이동
	 * 
	 * @return
	 */
	@RequestMapping("/chat.kh")
	public ModelAndView chat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat/chat");
		return mv;
	}

	/**
	 * 1.hearder.jsp 에서 「채팅」 버튼 누를 때 호출 채팅방 화면 이동
	 * 
	 * @return
	 */
	@RequestMapping("/room.kh")
	public ModelAndView room(ModelAndView mv) {
		mv.setViewName("chat/room");
		return mv;
	}

	/**
	 * 방 생성하기 다른 유저 id에서 클릭해서 유저 방을 만들어야합니다.
	 * 
	 * @param params
	 * @return
	 */
	// HashMap<Object, Object> params {roomName=입력한 방이름}
	@RequestMapping("/createRoom.kh")
	public @ResponseBody List<Room> createRoom(@RequestParam HashMap<Object, Object> params) {
		String roomName = (String) params.get("roomName");
		if (roomName != null && !roomName.trim().equals("")) {
			roomNumber = cService.printMaxRoomNum();
			Room room = new Room();
			room.setRoomNumber(++roomNumber);
			room.setRoomName(roomName);
			roomList.add(room);
		}
		return roomList;
	}

	/**
	 * 2.방 정보가져오기 -> 여기가 방정보 DB가 필요
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping("/getRoom.kh")
	public @ResponseBody List<Room> getRoom(@RequestParam HashMap<Object, Object> params, HttpSession session) {
		Member loginUser = (Member) session.getAttribute("loginUser");
		roomList = cService.printAllList(loginUser.getMemberNo());
		return roomList;
	}

	/**
	 * 채팅방
	 * 
	 * @return
	 */
	@RequestMapping("/moveChating.kh")
	public ModelAndView chating(ModelAndView mv, @RequestParam HashMap<Object, Object> params, HttpSession session) {
		int roomNumber = Integer.parseInt((String) params.get("roomNumber"));

		List<Room> new_list = roomList.stream().filter(o -> o.getRoomNumber() == roomNumber)
				.collect(Collectors.toList());
		if (new_list != null && new_list.size() > 0) {
			Member loginUser = (Member) session.getAttribute("loginUser");
			Room roominfo = new Room();
			roominfo.setMemberNo(loginUser.getMemberNo());
			roominfo.setRoomNumber(roomNumber);
			Room room = cService.printOneRoom(roominfo);
			mv.addObject("room", room);
			mv.addObject("roomName", params.get("roomName"));
			mv.addObject("roomNumber", params.get("roomNumber"));
			mv.setViewName("chat/chat");
		} else {
			mv.setViewName("chat/room");
		}
		return mv;
	}

	/**
	 * 채팅 내용 저장
	 * 
	 * @return
	 */
	@RequestMapping("/chatRegister.kh")
	public void registerChat(@ModelAttribute Chat chat) {
		try {
			int result = cService.registerChat(chat);
			log.info("채팅 저장 결과 : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 채팅 내용 가져오기
	 * 
	 * @return
	 */
	@RequestMapping("/chatLogDate.kh")
	public void chatLogDate(@RequestParam("roomNumber") int roomNumber, HttpServletResponse response) {
		try {
			ArrayList<Chat> chatList = cService.printAllChat(roomNumber);
			if (!chatList.isEmpty()) {
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
				gson.toJson(chatList, response.getWriter());
			} else {
				log.info("채팅 내역 리스트 가져오기 오류");
			}
			// 해당 채팅방의 마지막 메세지 업데이트 omg
		} catch (JsonIOException e) {
			e.printStackTrace();
			log.info("Json에러");
		} catch (IOException e) {
			e.printStackTrace();
			log.info("IOException");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("채팅 내용 저장 DB 에러");
		}
	}

}