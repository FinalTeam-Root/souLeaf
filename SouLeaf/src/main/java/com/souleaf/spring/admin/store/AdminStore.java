package com.souleaf.spring.admin.store;

import java.util.HashMap;

import com.souleaf.spring.admin.domain.MemberStatus;

public interface AdminStore {

	MemberStatus selectMemberStatus();
	int updateMemberStatus(HashMap<String, String> map);
}
