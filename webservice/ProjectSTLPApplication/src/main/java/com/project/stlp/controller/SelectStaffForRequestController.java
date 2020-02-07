package com.project.stlp.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.stlp.entity.Assign;
import com.project.stlp.entity.Center;
import com.project.stlp.entity.RequestForHelp;
import com.project.stlp.entity.Staff;
import com.project.stlp.repository.AssignRepository;
import com.project.stlp.repository.CenterRepository;
import com.project.stlp.repository.RequestForHelpRepository;
import com.project.stlp.repository.StaffRepository;
import com.project.stlp.util.ResponseObj;



@Controller
@RequestMapping(path = "/selectstaffforrequest")
public class SelectStaffForRequestController {
	
	@Autowired
	CenterRepository myCenterRepository;
	
	@Autowired
	StaffRepository mStaffRepository;

	@Autowired
	RequestForHelpRepository mRequestForHelpRepository;
	
	@Autowired
	AssignRepository mAssignRepository;

	
	@PostMapping(path = "/staffbytelcenter")
	public @ResponseBody ResponseObj listStaffsByTelCenter(@RequestBody String telcenter)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {

		List<Staff> queryListstaff = mStaffRepository.getStaffByTelCenter(telcenter.replaceAll("\"",""));

		if (queryListstaff == null)
			return new ResponseObj(500, "ไม่พบรายชื่อเจ้าหน้าที่?");

		return new ResponseObj(200, queryListstaff);
	}
	
	@PostMapping(path = "/setstaffforrequest")
	public @ResponseBody ResponseObj selectStaffForRequest(@RequestBody Map<String, Object> map)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {

		Object objStaff = map.get("staff");
		@SuppressWarnings("unchecked")
		Map<String, Object> mapStaff = (Map<String, Object>) objStaff;
		
		Object objRequest = map.get("requestforhelp");
		@SuppressWarnings("unchecked")
		Map<String, Object> mapRequest = (Map<String, Object>) objRequest;
		
		Assign assign = new Assign();
		assign.setFactperson((String)map.get("factperson"));
		assign.setFactfathermother((String)map.get("factfathermother"));
		assign.setForlegalopinion((String)map.get("forlegalopinion"));
		assign.setPersonstatus((String)map.get("personstatus"));
		assign.setStatusassign((int)map.get("statusassign"));
		
		String username = (String) mapStaff.get("username");
		Staff staff = null;
		try {
			staff = mStaffRepository.getStaffByUsername(username);
			if (staff == null) 
				return new ResponseObj(500, "ไม่พบชื่อเจ้าหน้าที่?");
		} catch (Exception e) {
			System.err.println("ไม่พบชื่อเจ้าหน้าที่?");
		}
		assign.setStaff(staff);
		
		int requestid = (int) mapRequest.get("requestid");
		RequestForHelp request = null;
		try {
			 request = mRequestForHelpRepository.getRequestByIdRequest(requestid);
			if (staff == null) 
				return new ResponseObj(500, "ไม่พบคำร้อง?");
		} catch (Exception e) {
			System.err.println("ไม่พบคำร้อง?");
		}
		assign.setRequestforhelp(request);

		mAssignRepository.save(assign);

		return new ResponseObj(200, assign);
	}


}
