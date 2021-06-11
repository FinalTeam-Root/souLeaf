package com.souleaf.spring.chat.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.chat.room.Chat;
import com.souleaf.spring.chat.room.Room;
import com.souleaf.spring.chat.store.ChatStore;

@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private ChatStore cStore;
	
	@Override
	public ArrayList<Room> printAllList(int memberNo) {
		return cStore.selectAllList(memberNo);
	}

	// 최신 채팅번호 취득
	@Override
	public int printMaxRoomNum() {
		return cStore.selectMaxRoomNum();
	}

	// 선택한 룸 정보 가져오기
	@Override
	public Room printOneRoom(Room roominfo) {
		return cStore.selectOneRoom(roominfo);
	}

	// 채팅 내용 저장
	@Override
	public int registerChat(Chat chat) {
		return cStore.insertChat(chat);
	}
	
	// 채팅 내용 가져오기
	@Override
	public ArrayList<Chat> printAllChat(int roomNumber) {
		return cStore.selectAllChat(roomNumber);
	}

	@Override
	public int registerRoom(Room room) {
		// TODO Auto-generated method stub
		return cStore.insertRoom(room);
	}	


}
