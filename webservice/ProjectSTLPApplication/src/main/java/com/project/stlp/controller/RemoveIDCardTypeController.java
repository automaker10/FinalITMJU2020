package com.project.stlp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.stlp.repository.IDCardTypeRepository;


@Controller
@RequestMapping("/removeidcardtype")
public class RemoveIDCardTypeController {

	@Autowired
	IDCardTypeRepository mIdcardTypeRepository;


	@RequestMapping(value = "/deleteidcardtype", method = RequestMethod.POST)
	public ModelAndView isRemoveIDCardType(@RequestParam("idcardno") String idcardno) {
		ModelAndView model = new ModelAndView("CompleteRemoveIDCardTypePage");
		mIdcardTypeRepository.deleteidcardTypeByIdcardno(idcardno);
		model.addObject("idcardno",idcardno);
		return model;
	}

}
