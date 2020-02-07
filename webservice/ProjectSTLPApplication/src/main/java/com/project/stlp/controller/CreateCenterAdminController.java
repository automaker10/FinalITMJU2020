package com.project.stlp.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.stlp.entity.Center;
import com.project.stlp.entity.Staff;
import com.project.stlp.repository.CenterRepository;
import com.project.stlp.repository.StaffRepository;
import com.project.stlp.util.PasswordUtil;

@Controller
@RequestMapping("/createcenteradmin")
public class CreateCenterAdminController {

	@Autowired
	CenterRepository centerRepository;

	@Autowired
	StaffRepository staffRepository;

	private static String SALT = "123456";


	@RequestMapping(value = "/addcenter", method = RequestMethod.POST)
	public ModelAndView viewCenter(@ModelAttribute("center") Center center) {
		ModelAndView model = new ModelAndView("CreateCenterAdminPage");
		model.addObject("center", center);
		return model;
	}

	@RequestMapping(value = "/savecenter", method = RequestMethod.POST)
	public ModelAndView isAddCenterAdminUser(@ModelAttribute("center") Center center,
			@RequestParam("nameperson") String nameperson, 
			@RequestParam("position") String position,
			@RequestParam("address") String address, 
			@RequestParam("username") String username,
			@RequestParam("password") String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		ModelAndView model = new ModelAndView("CreateCenterAdminPage");
		ModelAndView modelcomplete = new ModelAndView("CompleteCreateCenterAdminPage");
		
		if (centerRepository.checkDup(center.getTelcenter()) != null || staffRepository.checkDup(username) != null) {
			model.addObject("danger",
					"ศูนย์ให้ความช่วยเหลือฯนี้มีอยู่ในระบบแล้วหรือชื่อผู้ใช้งานนี้มีอยู่ในระบบแล้ว!!");
			return model;
		} else {
			
			Staff staff = new Staff();
			staff.setAddress(address.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C"));
			staff.setPosition(position);
			staff.setStatusstaff(1);
			staff.setNameperson(nameperson.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C"));
			staff.setEmailperson(center.getEmailcenter());
			staff.setTelperson(center.getTelcenter());
			staff.setUsername(username);
			staff.setPassword(PasswordUtil.getInstance().createPassword(password, SALT));
			staff.setType(3);
			
			List<Staff> staffs = new ArrayList<Staff>();
			
			staff.setCenter(center);
			
			staffs.add(staff);
			
			center.setStaffList(staffs);
			centerRepository.save(center);

			model.addObject("warning", "เพิ่มข้อมูลสำเร็จ");
			return modelcomplete;
		}

	}

}
