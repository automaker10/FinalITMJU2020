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
import com.project.stlp.entity.StatelessPerson;
import com.project.stlp.repository.AssignRepository;
import com.project.stlp.repository.RequestForHelpRepository;
import com.project.stlp.util.ResponseObj;


@Controller
@RequestMapping(path = "/viewsuggestion")
public class ViewSuggestionController {

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

	@PostMapping(path = "/viewsuggestionbyidrequest")
	public @ResponseBody ResponseObj viewSuggestionByUsername(@RequestBody int idrequest)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {


		List<Assign> viewsuggestion = mAssignRepository.getAssignByRequestIdAS3(idrequest);

		if (viewsuggestion == null) 
			return new ResponseObj(500, "คำร้องอยู่ระหว่างการพิจารณา?");

		return new ResponseObj(200, viewsuggestion);
	}


}
