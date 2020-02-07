package com.project.stlp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.stlp.entity.IDCardType;
import com.project.stlp.repository.IDCardTypeRepository;


@Controller
@RequestMapping(path = "/editidcardtype")
public class EditIDCardTypeController {

	@Autowired
	IDCardTypeRepository mIdcardTypeRepository;


	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView detailIDCardTypeByID(@RequestParam("idcardno") String idcardno) {
		ModelAndView model = new ModelAndView("EditIDCardTypePage");
		IDCardType idcardtype = mIdcardTypeRepository.getIDCardTypeByIDCard_NO(idcardno);
		model.addObject("idcardtype", idcardtype);
		return model;
	}

	@RequestMapping(value = "/updateidcardtype", method = RequestMethod.POST)
	public ModelAndView isUpdateIDCardType(@RequestParam("idcardno") String idcardno,
			@RequestParam("idcardcall") String idcardcall, @RequestParam("idcardmean") String idcardmean,
			@RequestParam("idcardjob") String idcardjob,
			@RequestParam("benefitsfromgovern") String benefitsfromgovern) {
		ModelAndView model = new ModelAndView("CompleteEditIDCardTypePage");
		model.addObject("idcardno",idcardno);
		IDCardType idcardtype = mIdcardTypeRepository.getIDCardTypeByIDCard_NO(idcardno);
		idcardtype.setIdcardcall(idcardcall);
		idcardtype.setIdcardmean(idcardmean);
		idcardtype.setIdcardjob(idcardjob);
		idcardtype.setBenefitsfromgovern(benefitsfromgovern);
		mIdcardTypeRepository.save(idcardtype);
		return model;
	}

}
