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

import com.project.stlp.entity.Center;
import com.project.stlp.entity.RequestForHelp;
import com.project.stlp.entity.StatelessPerson;
import com.project.stlp.repository.CenterRepository;
import com.project.stlp.repository.RequestForHelpRepository;
import com.project.stlp.repository.StatelessPersonRepository;
import com.project.stlp.util.ResponseObj;


@Controller
@RequestMapping(path = "/requestforhelp")
public class RequestForHelpController {

	@Autowired
	RequestForHelpRepository mRequestnRepository;

	@Autowired
	StatelessPersonRepository mStatelessPersonRepository;

	@Autowired
	CenterRepository mCenterRepository;
	
	@PostMapping(path = "/centerlist")
	public @ResponseBody ResponseObj getListCenter() {

		List<Center> listcenter = mCenterRepository.getListCenter();
		return new ResponseObj(200, listcenter);
	}

	@PostMapping(path = "/isAddRequest", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObj isAddRequest(@RequestBody Map<String, Object> map)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {

		Object objStattelessperson = map.get("statelessperon");
		@SuppressWarnings("unchecked")
		Map<String, Object> mapStatelessperson = (Map<String, Object>) objStattelessperson;

		Object objCenter = map.get("center");
		@SuppressWarnings("unchecked")
		Map<String, Object> mapCenter = (Map<String, Object>) objCenter;

		RequestForHelp request = new RequestForHelp();
		request.setCerbirth((Integer) map.get("cerbirth"));
		request.setTr1((Integer) map.get("tr1"));
		request.setTr2((Integer) map.get("tr2"));
		request.setTr3((Integer) map.get("tr3"));
		request.setTr0310((Integer) map.get("tr0310"));
		request.setTr1front((Integer) map.get("tr1front"));
		request.setTr11part1((Integer) map.get("tr11part1"));
		request.setBcerbirth((Integer) map.get("bcerbirth"));
		request.setBcerplacebirth((Integer) map.get("bcerplacebirth"));
		request.setCerregister((Integer) map.get("cerregister"));
		request.setTr14((Integer) map.get("tr14"));
		request.setTr13((Integer) map.get("tr13"));
		request.setFmperson((Integer) map.get("fmperson"));
		request.setHfmpersonno2((Integer) map.get("hfmpersonno2"));
		request.setTrchk((Integer) map.get("trchk"));
		request.setTr38g((Integer) map.get("tr38g"));
		request.setTr381((Integer) map.get("tr381"));
		request.setCeridcard((Integer) map.get("ceridcard"));
		request.setThaiidcard((Integer) map.get("thaiidcard"));
		request.setNotthaiidcard((Integer) map.get("notthaiidcard"));
		request.setStatelessidcard((Integer) map.get("statelessidcard"));
		request.setResidencycer((Integer) map.get("residencycer"));
		request.setRefugeeidcardfromwar((Integer) map.get("refugeeidcardfromwar"));
		request.setStatusrequest((Integer) map.get("statusrequest"));
		

		String username = (String) mapStatelessperson.get("username");
		StatelessPerson statelessperson = null;
		try {
			statelessperson = mStatelessPersonRepository.getStatelessPersonByusername(username);
			if (statelessperson == null) 
				return new ResponseObj(500, "กรุณาสร้างชื่อผู้ใช้งานก่อน?");
		} catch (Exception e) {
			System.err.println("ไม่พบศูนย์ให้ความช่วยเหลือฯ?");
		}
		request.setStatelessperon(statelessperson);

		String tel_center = (String) mapCenter.get("telcenter");
		Center center = null;
		try {
			center = mCenterRepository.getCenterByTelCenter(tel_center);
		} catch (Exception e) {
			System.err.println("ไม่พบศูนย์ให้ความช่วยเหลือฯ?");
		}
		request.setCenter(center);
		
		
		RequestForHelp queryRequest = mRequestnRepository.getDetailrequestByUsername(username);
		
		if(queryRequest==null) {
			 mRequestnRepository.save(request);
		}else if(queryRequest!=null){
			queryRequest.setCerbirth(request.getCerbirth());
			queryRequest.setTr1(request.getTr1());
			queryRequest.setTr2(request.getTr2());
			queryRequest.setTr3(request.getTr3());
			queryRequest.setTr0310(request.getTr0310());
			queryRequest.setTr1front(request.getTr1front());
			queryRequest.setTr11part1(request.getTr11part1());
			queryRequest.setBcerbirth(request.getBcerbirth());
			queryRequest.setBcerplacebirth(request.getBcerplacebirth());
			queryRequest.setCerregister(request.getCerregister());
			queryRequest.setTr14(request.getTr14());
			queryRequest.setTr13(request.getTr13());
			queryRequest.setFmperson(request.getFmperson());
			queryRequest.setHfmpersonno2(request.getHfmpersonno2());
			queryRequest.setTrchk(request.getTrchk());
			queryRequest.setTr38g(request.getTr38g());
			queryRequest.setTr381(request.getTr381());
			queryRequest.setCeridcard(request.getCeridcard());
			queryRequest.setThaiidcard(request.getThaiidcard());
			queryRequest.setNotthaiidcard(request.getNotthaiidcard());
			queryRequest.setStatelessidcard(request.getStatelessidcard());
			queryRequest.setResidencycer(request.getResidencycer());
			queryRequest.setRefugeeidcardfromwar(request.getRefugeeidcardfromwar());
			queryRequest.setStatusrequest(request.getStatusrequest());
			queryRequest.setStatelessperon(request.getStatelessperon());
			queryRequest.setCenter(request.getCenter());
			mRequestnRepository.save(queryRequest);
		}
	
		return new ResponseObj(200, request);
	}
	
	
	@PostMapping(path = "/detailrequestbyusername", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObj detailRequestByUsername(@RequestBody Map<String, Object> map)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
			
		StatelessPerson statelessperson = new StatelessPerson();
		statelessperson.setUsername((String)map.get("username"));
		
		RequestForHelp request = mRequestnRepository.getDetailrequestByUsername(statelessperson.getUsername());
		
		if (request == null)
			return new ResponseObj(500, "บัญชีนี้ยังไม่ได้เขียนคำร้อง?");

		return new ResponseObj(200, request);
	}
}
