package com.project.stlp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.stlp.repository.AssignRepository;
import com.project.stlp.repository.StaffRepository;


@Controller
@RequestMapping("/removetaff")
public class RemoveStaffController {


	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	AssignRepository assignRepository;


	@RequestMapping(value = "/deletestaff", method = RequestMethod.POST)
	public ModelAndView isRemoveStaffUser(@RequestParam("username") String username,
			@RequestParam("telcenter") String telcenter,
			@RequestParam("usernamepresident") String usernamepresident,
			@RequestParam("password") String password,
			@RequestParam("nameperson") String nameperson) {
		
		ModelAndView model = new ModelAndView("CompleteRemoveStaffUserPage");
		model.addObject("telcenter",telcenter);
		model.addObject("username",usernamepresident);
		model.addObject("password",password);
		model.addObject("nameperson",nameperson);
		assignRepository.deleteAssignByUsername(username);
		staffRepository.deleteStaffByUsername(username);
		
		return model;
	}

}