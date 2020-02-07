package com.project.stlp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.stlp.entity.Staff;
import com.project.stlp.repository.StaffRepository;



@Controller
@RequestMapping("/liststaff")
public class ListAllStaffsController {

	@Autowired
	StaffRepository staffRepository;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView listAllStaffsByTelcenter(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("telcenter") String telcenter) {
		ModelAndView model = new ModelAndView("ListAllStaffsUserPage");
		model.addObject("telcenter",telcenter);
		model.addObject("username",username);
		model.addObject("password",password);
		List<Staff> liststaff = staffRepository.getStaffByTelCenter(telcenter);
		model.addObject("liststaff",liststaff);
		return model;
	}

}
