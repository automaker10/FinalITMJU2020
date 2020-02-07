package com.project.stlp.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import java.util.List;
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
import com.project.stlp.repository.AddressRepository;
import com.project.stlp.repository.AssignRepository;
import com.project.stlp.repository.EducationRepository;
import com.project.stlp.repository.ParentRepository;
import com.project.stlp.repository.RequestForHelpRepository;
import com.project.stlp.repository.WitnessRepository;
import com.project.stlp.util.ResponseObj;



@Controller
@RequestMapping(path = "/choosethebest")
public class ChooseTheBestSuggestionController {

	
	@Autowired
	EducationRepository mEducationRepository;

	@Autowired
	WitnessRepository mWitnessRepository;

	@Autowired
	AddressRepository mAddressRepository;

	@Autowired
	ParentRepository mParentRepository;
	
	@Autowired
	AssignRepository mAssignRepository;
	
	@Autowired
	RequestForHelpRepository mRequestnRepository;
	
	@PostMapping(path = "/detailrequestbyusername", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObj detailRequestByUsername(@RequestBody String username)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
			
		RequestForHelp request = mRequestnRepository.getDetailrequestByUsername(username.replaceAll("\"",""));
		
		if (request == null)
			return new ResponseObj(500, "บัญชีนี้ยังไม่ได้เขียนคำร้อง?");

		return new ResponseObj(200, request);
	}
	
	@PostMapping(path = "/suggestionbyidrequest")
	public @ResponseBody ResponseObj getListAssignByUsernamerequest(@RequestBody int idrequest)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {

		List<Assign> queryListassign = mAssignRepository.getAssignByRequestId(idrequest);

		if (queryListassign == null)
			return new ResponseObj(500, "ไม่พบรายการคำร้อง?");

		return new ResponseObj(200, queryListassign);
	}
	
	@PostMapping(path = "/detailsuggestionbyassignid")
	public @ResponseBody ResponseObj getDetailAssignByidAssign(@RequestBody int idassign)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {

		Assign queryAssign = mAssignRepository.getAssignByAssignid(idassign);

		return new ResponseObj(200, queryAssign);
	}
	
	@PostMapping(path = "/choosethebestsuggestion")
	public @ResponseBody ResponseObj chooseTheBestSuggestion(@RequestBody Map<String, Object> map)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {

		Assign assign = new Assign();
		assign.setAssignid((int) map.get("assignid"));

		Assign givesuggestion = mAssignRepository.getAssignByAssignid(assign.getAssignid());

		givesuggestion.setStatusassign(3);
		givesuggestion.getRequestforhelp().setStatusrequest(3);

		mAssignRepository.save(givesuggestion);

		return new ResponseObj(200, givesuggestion);
	}


}
