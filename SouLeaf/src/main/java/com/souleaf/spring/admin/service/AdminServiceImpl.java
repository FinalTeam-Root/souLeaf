package com.souleaf.spring.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleaf.spring.admin.store.AdminStore;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminStore aStore;
}
