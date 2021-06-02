package com.souleaf.spring.admin.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.souleaf.spring.admin.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService aService;
	
	@RequestMapping(value = "adminHome.kh", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("nav", "home");
		return "admin/adminHome";
	}
}
