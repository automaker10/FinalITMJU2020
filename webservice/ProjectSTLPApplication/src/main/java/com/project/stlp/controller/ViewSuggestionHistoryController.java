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
import com.project.stlp.entity.Staff;
import com.project.stlp.repository.AssignRepository;
import com.project.stlp.repository.RequestForHelpRepository;
import com.project.stlp.util.ResponseObj;



@Controller
@RequestMapping(path = "/suggestionhistory")
public class ViewSuggestionHistoryController {

	
	@Autowired
	AssignRepository mAssignRepository;
	
	@Autowired
	RequestForHelpRepository mRequestnRepository;
	
	
	@PostMapping(path = "/listhistory")
	public @ResponseBody ResponseObj listSuggestionHistoryByUsernameAndStatusAssign(@RequestBody String username)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {


		List<Assign> queryListassign = mAssignRepository.listSuggestionHistory(username.replaceAll("\"",""));

		if (queryListassign == null)
			return new ResponseObj(500, "ไม่พบรายการคำร้อง?");

		return new ResponseObj(200, queryListassign);
	}
	
	@PostMapping(path = "/getdetailsrequestbyidrequest", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObj detailRequestByIdRequest(@RequestBody int idrequest)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
			
		RequestForHelp requestbyid = mRequestnRepository.getRequestByIdRequest(idrequest);
		
		if (requestbyid == null)
			return new ResponseObj(500, "ไม่พบคำร้อง?");

		return new ResponseObj(200, requestbyid);
	}
	
	@PostMapping(path = "/detailsuggestionbyidassign")
	public @ResponseBody ResponseObj viewSuggestionHistory(@RequestBody int assignid)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {

		Assign queryAssign = mAssignRepository.getAssignByAssignid(assignid);

		return new ResponseObj(200, queryAssign);
	}


}
