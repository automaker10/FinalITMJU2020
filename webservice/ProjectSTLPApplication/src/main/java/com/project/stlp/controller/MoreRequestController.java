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
import com.project.stlp.entity.MoreRequest;
import com.project.stlp.entity.RequestForHelp;
import com.project.stlp.repository.AssignRepository;
import com.project.stlp.repository.MoreRequestForHelpRepository;
import com.project.stlp.repository.RequestForHelpRepository;
import com.project.stlp.util.ResponseObj;




@Controller 
@RequestMapping(path = "/morerequestforhelp")
public class MoreRequestController {

	@Autowired
	RequestForHelpRepository mRequestnRepository;

	@Autowired
	MoreRequestForHelpRepository mMoreRequestRepository;
	
	@Autowired
	AssignRepository mAssignRepository;

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObj isAddMoreRequest(@RequestBody Map<String, Object> map)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {

		Object objRequest = map.get("requestforhelp");
		@SuppressWarnings("unchecked")
		Map<String, Object> mapRequest = (Map<String, Object>) objRequest;

		MoreRequest morerequest = null;

		morerequest = new MoreRequest();
		morerequest = setMoreRequest(morerequest, map, mapRequest);

		mMoreRequestRepository.save(morerequest);

		return new ResponseObj(200, morerequest);
	}

	public MoreRequest setMoreRequest(MoreRequest morerequest, Map<String, Object> map, Map<String, Object> mapRequest)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {

		morerequest.setWhatstoryforrequest((String) map.get("whatstoryforrequest"));
		morerequest.setAnswer((String)map.get("answer"));
		morerequest.setStatusmrequest((Integer) map.get("statusmrequest"));

		int idrequest = (int) mapRequest.get("requestid");
		RequestForHelp requestforhelp = null;
		try {
			requestforhelp = mRequestnRepository.getRequestByIdRequest(idrequest);
		} catch (Exception e) {
			System.err.println("ไม่พบคำร้องขอความช่วยเหลือ?");
		}
		morerequest.setRequestforhelp(requestforhelp);

		return morerequest;
	}
	
	@PostMapping(path = "/detailsuggestionbyidassign")
	public @ResponseBody ResponseObj detailSuggestionByIdassign(@RequestBody int assignid)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {

		Assign queryAssign = mAssignRepository.getAssignByAssignid(assignid);

		return new ResponseObj(200, queryAssign);
	}
	
	@PostMapping(path = "/getdetailsrequestbyidrequest", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObj detailRequestByUsername(@RequestBody int idrequest)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
			
		RequestForHelp requestbyid = mRequestnRepository.getRequestByIdRequest(idrequest);
		
		if (requestbyid == null)
			return new ResponseObj(500, "ไม่พบคำร้อง?");

		return new ResponseObj(200, requestbyid);
	}
	
	@PostMapping(path = "/listmorerequestbyidrequest")
	public @ResponseBody ResponseObj getListMoreRequestByIdrequest(@RequestBody int requestid)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
		
		List<MoreRequest> queryListMoreRequest = mMoreRequestRepository.getMoreRequestByRequestId(requestid);

		return new ResponseObj(200, queryListMoreRequest);
	}
	
	@PostMapping(path = "/answermorerequest")
	public @ResponseBody ResponseObj answerMoreRequest(@RequestBody Map<String, Object> map)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {

		MoreRequest morerequest = new MoreRequest();
		morerequest.setMorerequestid((int)map.get("morerequestid"));
		morerequest.setWhatstoryforrequest((String)map.get("whatstoryforrequest"));
		morerequest.setAnswer((String)map.get("answer"));
		morerequest.setStatusmrequest(2);

		MoreRequest answermorerequest = mMoreRequestRepository.getMoreRequestById(morerequest.getMorerequestid());
		answermorerequest.setAnswer(morerequest.getAnswer());
		answermorerequest.setStatusmrequest(morerequest.getStatusmrequest());

		mMoreRequestRepository.save(answermorerequest);

		return new ResponseObj(200, answermorerequest);
	}
	
	@PostMapping(path = "/removeMoreRequest")
	public @ResponseBody ResponseObj removeMoreRequest(@RequestBody Map<String, Object> map)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {

		MoreRequest morerequest = new MoreRequest();
		morerequest.setMorerequestid((int)map.get("morerequestid"));

		mMoreRequestRepository.deleteMoreRequestByid(morerequest.getMorerequestid());

		return new ResponseObj(200, morerequest);
	}
	
	@PostMapping(path = "/detailsuggestionbyassignid")
	public @ResponseBody ResponseObj getDetailAssignByidAssign(@RequestBody Map<String, Object> map)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
		Assign assign = new Assign();
		assign.setAssignid((int) map.get("assignid"));

		Assign queryAssign = mAssignRepository.getAssignByAssignid(assign.getAssignid());

		return new ResponseObj(200, queryAssign);
	}

}
