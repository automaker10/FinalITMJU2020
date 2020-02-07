package com.project.stlp.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.stlp.entity.IDCardType;
import com.project.stlp.repository.IDCardTypeRepository;
import com.project.stlp.util.ResponseObj;



@Controller
@RequestMapping(path = "/searchidcardtype")
public class SearchIDCardTypeController {
	@Autowired
	IDCardTypeRepository mIdcardTypeRepository;
	
	@PostMapping(path = "/searchidcardtypebypattern")
	public @ResponseBody ResponseObj searchIdcardByIdcardNo(@RequestBody String idcardno)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
				
		IDCardType queryIdcardType = mIdcardTypeRepository.getIDCardTypeByIDCard_NO(idcardno.replaceAll("\"",""));

		if (queryIdcardType == null)
			return new ResponseObj(500, "ไม่พบประเภทบัตรบุคคลไร้รัฐไร้สัญชาติ?");

		return new ResponseObj(200, queryIdcardType);
	}

}
