package com.project.stlp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.stlp.repository.CenterRepository;
import com.project.stlp.repository.StaffRepository;


@Controller
@RequestMapping("/removecenteradmin")
public class RemoveCenterAdminController {

	@Autowired
	CenterRepository centerRepository;

	@Autowired
	StaffRepository staffRepository;


	@RequestMapping(value = "/deletecenter", method = RequestMethod.POST)
	public ModelAndView isRemoveCenterAdmin(@RequestParam("telcenter") String telcenter,
			@RequestParam("namecenter") String namecenter) {
		ModelAndView model = new ModelAndView("CompleteRemoveCenterAdminPage");
		model.addObject("namecenter",namecenter);
		staffRepository.deletePresidentByTelcenter(telcenter);
		centerRepository.deleteCenterByTel(telcenter);
		return model;
	}

}
