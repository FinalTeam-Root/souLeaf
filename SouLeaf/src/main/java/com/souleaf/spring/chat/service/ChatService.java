package com.souleaf.spring.chat.service;

import java.util.ArrayList;

import com.souleaf.spring.chat.room.Chat;
import com.souleaf.spring.chat.room.Room;

public interface ChatService {

	public ArrayList<Room> printAllList(int memberNo); // 채팅방 리스트

	public int printMaxRoomNum(); // 최신 채팅번호 취득

	public Room printOneRoom(Room roominfo); // 선택한 룸 정보 가져오기

	public int registerChat(Chat chat); // 채팅 내용 저장
	
	public ArrayList<Chat> printAllChat(int roomNumber); // 채팅 내용 가져오기

}
