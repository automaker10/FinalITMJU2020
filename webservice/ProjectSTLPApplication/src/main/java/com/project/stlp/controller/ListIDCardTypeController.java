package com.project.stlp.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.stlp.entity.IDCardType;
import com.project.stlp.repository.IDCardTypeRepository;


@Controller
@RequestMapping(path = "/listidcardtype")
public class ListIDCardTypeController {

	@Autowired
	IDCardTypeRepository mIdcardTypeRepository;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView listAllIDCardType() {
		ModelAndView model = new ModelAndView("ListAllIDCardtypePage");
		List<IDCardType> listidcardtype = mIdcardTypeRepository.getListIdCardType();
		model.addObject("list",listidcardtype);
		return model;
	}

}
