package com.souleaf.spring.admin.service;

import java.util.HashMap;

import com.souleaf.spring.admin.domain.MemberStatus;

public interface AdminService {

	MemberStatus printMemberStatus();

	int modifyMemberStatus(HashMap<String, String> map);

}
