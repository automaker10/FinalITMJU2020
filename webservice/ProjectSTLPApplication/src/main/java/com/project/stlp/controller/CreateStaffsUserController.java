package com.project.stlp.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

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
import com.project.stlp.util.PasswordUtil;


@Controller
@RequestMapping("/createstaff")
public class CreateStaffsUserController {

	@Autowired
	CenterRepository centerRepository;

	@Autowired
	StaffRepository staffRepository;

	private static String SALT = "123456";

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView addStaff(@RequestParam("telcenter") String telcenter,
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		ModelAndView model = new ModelAndView("CreateStaffUserPage");
		model.addObject("telcenter",telcenter);
		model.addObject("username",username);
		model.addObject("password",password);
		return model;
	}
	@RequestMapping(value = "/savestaff", method = RequestMethod.POST)
	public ModelAndView isAddStaffUser(@RequestParam("telcenter") String telcenter,
			@RequestParam("nameperson") String nameperson, 
			@RequestParam("position") String position,
			@RequestParam("emailperson") String emailperson, 
			@RequestParam("telperson") String telperson,
			@RequestParam("username") String usernamestaff,
			@RequestParam("address") String address,
			@RequestParam("passwordstaff") String password,
			@RequestParam("usernamepresident") String usernamepresident,
			@RequestParam("passwordpresident") String passwordpresident) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		ModelAndView model = new ModelAndView("CreateStaffUserPage");
		ModelAndView modelcomplete = new ModelAndView("CompleteCreateStaffUserPage");
		if (staffRepository.checkDup(usernamestaff) != null) {
			model.addObject("danger",
					"ชื่อผู้ใช้งานนี้มีอยู่ในระบบแล้ว!!");
			model.addObject("telcenter",
					telcenter);
			model.addObject("username",
					usernamepresident);
			model.addObject("password",
					passwordpresident);
			return model;
		} else {
			Center center = centerRepository.getCenterByTelCenter(telcenter);
			Staff staff = new Staff();
			staff.setAddress(address.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C").replaceAll("\n","%0A"));
			staff.setPosition(position.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C"));
			staff.setStatusstaff(2);
			staff.setNameperson(nameperson.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C"));
			staff.setEmailperson(emailperson);
			staff.setTelperson(telperson);
			staff.setUsername(usernamestaff);
			staff.setPassword(PasswordUtil.getInstance().createPassword(password, SALT));
			staff.setType(2);
			staff.setCenter(center);
			staffRepository.save(staff);
			modelcomplete.addObject("warning", "เพิ่มข้อมูลสำเร็จ");
			modelcomplete.addObject("telcenter",
					telcenter);
			modelcomplete.addObject("username",
					usernamepresident);
			modelcomplete.addObject("password",
					passwordpresident);
			return modelcomplete;
		}
	}
	
	@RequestMapping(value = "/editstaff", method = RequestMethod.POST)
	public ModelAndView editStaff(@RequestParam("username") String username,
			@RequestParam("telcenter") String telcenter,
			@RequestParam("usernamepresident") String usernamepresident,
			@RequestParam("password") String password) {
		ModelAndView model = new ModelAndView("EditStaffUserPage");
		Staff staff = staffRepository.getStaffByUsername(username);
		model.addObject("staff", staff);
		model.addObject("telcenter", telcenter);
		model.addObject("username", usernamepresident);
		model.addObject("password", password);
		return model;
	}
	
	@RequestMapping(value = "/updatestaff", method = RequestMethod.POST)
	public ModelAndView updateCenter(@RequestParam("usernamestaff") String usernamstaff,
			@RequestParam("usernamepresident") String usernamepresident,
			@RequestParam("passwordpresident") String passwordpresident,
			@RequestParam("telcenter") String telcenter,
			@RequestParam("nameperson") String nameperson,
			@RequestParam("position") String position,
			@RequestParam("emailperson") String emailperson,
			@RequestParam("telperson") String telperson,
			@RequestParam("address") String address) {
		ModelAndView model = new ModelAndView("CompleteEditStaffUserPage");
		model.addObject("username",usernamepresident);
		model.addObject("password",passwordpresident);
		model.addObject("telcenter",telcenter);
		model.addObject("nameperson",nameperson);
		Staff staff = staffRepository.getStaffByUsername(usernamstaff);
		staff.setNameperson(nameperson.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C"));
		staff.setPosition(position.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C"));
		staff.setEmailperson(emailperson);
		staff.setTelperson(telperson);
		staff.setAddress(address.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C").replaceAll("\n","%0A"));
		staffRepository.save(staff);
		return model;
	}

}
