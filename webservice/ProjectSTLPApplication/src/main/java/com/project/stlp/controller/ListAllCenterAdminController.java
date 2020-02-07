package com.project.stlp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.stlp.entity.Center;
import com.project.stlp.entity.Staff;
import com.project.stlp.repository.CenterRepository;
import com.project.stlp.repository.StaffRepository;

@Controller
@RequestMapping("/listallcenter")
public class ListAllCenterAdminController {

	@Autowired
	CenterRepository centerRepository;
	
	@Autowired
	StaffRepository staffRepository;


	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView listAllCenterAdmin() {
		ModelAndView model = new ModelAndView("ListAllCenterAdminUserPage");
		List<Center> centerList = centerRepository.getListCenter();
		model.addObject("list", centerList);
		return model;
	}
	
	@RequestMapping(value = "/editcenter", method = RequestMethod.POST)
	public ModelAndView editCenter(@RequestParam("telcenter") String telcenter) {
		ModelAndView model = new ModelAndView("editcenter");
		Center center = centerRepository.getCenterByTelCenter(telcenter);
		Staff president = staffRepository.getPresidenByTelCenter(telcenter);
		model.addObject("center", center);
		model.addObject("president", president);
		return model;
	}
	
	@RequestMapping(value = "/updatecenter", method = RequestMethod.POST)
	public ModelAndView updateCenter(@RequestParam("telcenter") String telcenter,
			@RequestParam("namecenter") String namecenter, @RequestParam("emailcenter") String emailcenter,
			@RequestParam("addresscenter") String addresscenter, @RequestParam("nameperson") String nameperson,
			@RequestParam("position") String position, @RequestParam("address") String address,
			@RequestParam("username") String username) {
		ModelAndView model = new ModelAndView("CompleteEditCenterAdminPage");
		Center center = centerRepository.getCenterByTelCenter(telcenter);
		center.setNamecenter(namecenter);
		center.setEmailcenter(emailcenter);
		center.setAddresscenter(addresscenter);
		centerRepository.save(center);
		Staff president = staffRepository.getStaffByUsername(username);
		president.setNameperson(nameperson);
		president.setPosition(position);
		president.setAddress(address);
		president.setEmailperson(emailcenter);
		president.setTelperson(telcenter);
		staffRepository.save(president);
		return model;
	}

}
