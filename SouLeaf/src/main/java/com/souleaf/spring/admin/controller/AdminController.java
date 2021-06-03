package com.souleaf.spring.admin.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.souleaf.spring.admin.service.AdminService;
import com.souleaf.spring.plant.domain.Plant;
import com.souleaf.spring.plant.service.PlantService;

@Controller
public class AdminController {
	@Autowired
	private AdminService aService;
	
	@Autowired
	private PlantService pService;
	
	@RequestMapping(value = "adminHome.kh", method = RequestMethod.GET)
	public String adminHome(Locale locale, Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("nav", "admin");
		return "admin/adminHome";
	}
	
	@RequestMapping(value = "adminPlant.kh", method = RequestMethod.GET)
	public ModelAndView adminPlant(ModelAndView mv) {
		ArrayList<Plant> pList = pService.printAllList();
		mv.addObject("pList",pList).setViewName("admin/adminPlant");
		return mv;
	}
	
	@RequestMapping(value="adminPlantDelete.kh")
	public String adminPlantDelete(@RequestParam("plant-check") String[] checkBox) {
		String plantNo = "";
		for(String no : checkBox) {
			if(no.equals(checkBox[checkBox.length-1])) {
				plantNo += no;
			}else {
				plantNo += no+",";
			}
		}
		System.out.println(plantNo);
		return "redirect:adminPlant.kh";
	}
}
