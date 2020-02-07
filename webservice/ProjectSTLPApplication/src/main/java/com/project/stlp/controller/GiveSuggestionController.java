package com.project.stlp.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.stlp.entity.Assign;
import com.project.stlp.entity.RequestForHelp;
import com.project.stlp.repository.AssignRepository;
import com.project.stlp.repository.RequestForHelpRepository;
import com.project.stlp.util.ResponseObj;




@Controller
@RequestMapping(path = "/givesuggestion")
public class GiveSuggestionController {

	@Autowired
	RequestForHelpRepository mRequestnRepository;

	@Autowired
	AssignRepository mAssignRepository;

	
	@PostMapping(path = "/getdetailsrequestbyidrequest", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObj detailRequestByUsername(@RequestBody int idrequest)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
			
		RequestForHelp requestbyid = mRequestnRepository.getRequestByIdRequest(idrequest);
		
		if (requestbyid == null)
			return new ResponseObj(500, "ไม่พบคำร้อง?");

		return new ResponseObj(200, requestbyid);
	}
	
	@PostMapping(path = "/setsuggestionrequest")
	public @ResponseBody ResponseObj giveSuggestion(@RequestBody Map<String, Object> map)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {

		Assign assign = new Assign();
		assign.setAssignid((int) map.get("assignid"));
		assign.setFactperson((String) map.get("factperson"));
		assign.setFactfathermother((String) map.get("factfathermother"));
		assign.setForlegalopinion((String) map.get("forlegalopinion"));
		assign.setPersonstatus((String) map.get("personstatus"));

		Assign givesuggestion = mAssignRepository.getAssignByAssignid(assign.getAssignid());

		givesuggestion.setFactperson(assign.getFactperson());
		givesuggestion.setFactfathermother(assign.getFactfathermother());
		givesuggestion.setForlegalopinion(assign.getForlegalopinion());
		givesuggestion.setPersonstatus(assign.getPersonstatus());
		givesuggestion.setStatusassign(2);

		mAssignRepository.save(givesuggestion);

		return new ResponseObj(200, givesuggestion);
	}
}
