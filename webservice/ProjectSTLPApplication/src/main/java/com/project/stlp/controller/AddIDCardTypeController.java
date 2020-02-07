package com.project.stlp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.stlp.entity.IDCardType;
import com.project.stlp.repository.IDCardTypeRepository;


@Controller
@RequestMapping(path = "/addidcardtype")
public class AddIDCardTypeController {

	@Autowired
	IDCardTypeRepository mIdcardTypeRepository;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView viewIdCardType(@ModelAttribute("idcardtype") IDCardType idcardtype) {
		ModelAndView model = new ModelAndView("AddIDCardTypePage");
		model.addObject("idcardtype", idcardtype);
		return model;
	}
	
	@RequestMapping(value = "/saveidcardtype", method = RequestMethod.POST)
	public ModelAndView isAddIDCardType(@ModelAttribute("idcardtype") IDCardType idcardtype) {
		ModelAndView model = new ModelAndView("AddIDCardTypePage");
		ModelAndView modelcomplete = new ModelAndView("CompleteAddIDCardTypePage");
		if (mIdcardTypeRepository.checkDup(idcardtype.getIdcardno()) != null) {
			model.addObject("danger", "ประเภทบัตรนี้มีอยู่ในระบบแล้ว!!");
			return model;
		} else {
			mIdcardTypeRepository.save(idcardtype);
			model.addObject("warning", "เพิ่มข้อมูลสำเร็จ");
			return modelcomplete;
		}

	}

}
