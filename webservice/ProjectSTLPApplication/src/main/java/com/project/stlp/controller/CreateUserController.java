package com.project.stlp.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.stlp.entity.Address;
import com.project.stlp.entity.Education;
import com.project.stlp.entity.IDCardType;
import com.project.stlp.entity.Parent;
import com.project.stlp.entity.StatelessPerson;
import com.project.stlp.entity.Witness;
import com.project.stlp.repository.AddressRepository;
import com.project.stlp.repository.EducationRepository;
import com.project.stlp.repository.IDCardTypeRepository;
import com.project.stlp.repository.ParentRepository;
import com.project.stlp.repository.StatelessPersonRepository;
import com.project.stlp.repository.WitnessRepository;
import com.project.stlp.util.PasswordUtil;
import com.project.stlp.util.ResponseObj;


@Controller
@RequestMapping(path = "/createuser")
public class CreateUserController {
	
	@Autowired
	StatelessPersonRepository mStatelessPersonRepository;
	
	@Autowired
	IDCardTypeRepository mIDCardTypeRepository;

	@Autowired
	AddressRepository mAddressRepository;

	@Autowired
	EducationRepository mEducationRepository;

	@Autowired
	ParentRepository mParentRepository;

	@Autowired
	WitnessRepository mWitnessRepository;

	private static String SALT = "123456";

	@PostMapping(path = "/isaddUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseObj isAddUser(@RequestBody Map<String, Object> map)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {

		Object objIDCardType = map.get("idcardtype");
		@SuppressWarnings("unchecked")
		Map<String, Object> mapIDCardType = (Map<String, Object>) objIDCardType;

		Object objAddress = map.get("addressList");
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> mapAddress = (List<Map<String, Object>>) objAddress;

		Object objEducation = map.get("educationList");
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> mapEducation = (List<Map<String, Object>>) objEducation;

		Object objParent = map.get("parentList");
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> mapParent = (List<Map<String, Object>>) objParent;

		Object objWitness = map.get("witnessList");
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> mapWitness = (List<Map<String, Object>>) objWitness;

		StatelessPerson statelessperson = null;

		statelessperson = new StatelessPerson();
		statelessperson = setUser(statelessperson, map, mapIDCardType);

		if (mStatelessPersonRepository.checkDup((String) map.get("username")) != null)
			return new ResponseObj(500, "ชื่อผู้ใช้นี้มีอยู่ในระบบแล้ว!!");

		mStatelessPersonRepository.save(statelessperson);

		for (Map<String, Object> add : mapAddress) {
			Address address = new Address();
			address.setDetailaddress((String) add.get("detailaddress"));
			address.setFromyears((String) add.get("fromyears"));
			address.setToyears((String) add.get("toyears"));
			address.setHomestatus((Integer) add.get("homestatus"));
			address.setStatusaddress((Integer) add.get("statusaddress"));
			address.setStateleeeperson(statelessperson);
			mAddressRepository.save(address);
		}

		for (Map<String, Object> edu : mapEducation) {
			Education education = new Education();
			education.setEducationdetails((String) edu.get("educationdetails"));
			education.setStateleeeperson(statelessperson);
			mEducationRepository.save(education);
		}

		for (Map<String, Object> wit : mapWitness) {
			Witness witness = new Witness();
			witness.setNamewitness((String) wit.get("namewitness"));
			witness.setRelationship((String) wit.get("relationship"));
			witness.setStatusbealive((Integer) wit.get("statusbealive"));
			witness.setAddresswitness((String) wit.get("addresswitness"));
			witness.setStateleeeperson(statelessperson);
			mWitnessRepository.save(witness);
		}

		for (Map<String, Object> par : mapParent) {
			Parent parent = new Parent();
			parent.setName((String) par.get("name"));
			parent.setStatusbealive((Integer) par.get("statusbealive"));
			parent.setBirthday((String) par.get("birthday"));
			parent.setIdcard((String) par.get("idcard"));
			parent.setEthnic((String) par.get("ethnic"));
			parent.setNationality((String) par.get("nationality"));
			parent.setDatecomethai((String) par.get("datecomethai"));
			parent.setAddress((String) par.get("address"));
			parent.setStatusparent((Integer) par.get("statusparent"));
			parent.setStateleeeperson(statelessperson);
			mParentRepository.save(parent);
		}

		return new ResponseObj(200, statelessperson);
	}

	public StatelessPerson setUser(StatelessPerson statelessperson, Map<String, Object> map, Map<String, Object> mapIDCardType) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		statelessperson.setGender((Integer) map.get("gender"));
		Date birthday = new Date((Long) map.get("birthday"));
		statelessperson.setBirthday(birthday);
		statelessperson.setReligion((String) map.get("religion"));
		statelessperson.setEthnic((String) map.get("ethnic"));
		statelessperson.setNationality((String) map.get("nationality"));
		statelessperson.setHomeid((String) map.get("homeid"));
		statelessperson.setIdcard((String) map.get("idcard"));
		statelessperson.setStatusmarry((Integer) map.get("statusmarry"));
		statelessperson.setNameofspouse((String) map.get("nameofspouse"));
		statelessperson.setIdcardofspouse((String) map.get("idcardofspouse"));
		statelessperson.setNationalityofspouse((String) map.get("nationalityofspouse"));
		statelessperson.setDateofmarry((String) map.get("dateofmarry"));
		statelessperson.setAddressofspouse((String) map.get("addressofspouse"));
		statelessperson.setStatusplaceofbirth((Integer) map.get("statusplaceofbirth"));
		statelessperson.setStatusthaiorabroadbirth((Integer) map.get("statusthaiorabroadbirth"));
		statelessperson.setHospitalofbirth((String) map.get("hospitalofbirth"));
		statelessperson.setAddressofvillagebirth((String) map.get("addressofvillagebirth"));
		statelessperson.setStatuswitness((Integer) map.get("statuswitness"));
		statelessperson.setCountryofbirth((String) map.get("countryofbirth"));
		statelessperson.setDistrictcomethai((String) map.get("districtcomethai"));
		statelessperson.setDatecomethai((String) map.get("datecomethai"));
		statelessperson.setModecomethai((String) map.get("modecomethai"));
		statelessperson.setNameperson((String) map.get("nameperson"));
		statelessperson.setEmailperson((String) map.get("emailperson"));
		statelessperson.setTelperson((String) map.get("telperson"));
		statelessperson.setUsername((String) map.get("username"));
		statelessperson.setPassword(PasswordUtil.getInstance().createPassword((String) map.get("password"), SALT));
		statelessperson.setType((Integer) map.get("type"));

		String idcard_no = (String) mapIDCardType.get("idcardno");
		IDCardType idcardtype = null;
		try {
			idcardtype = mIDCardTypeRepository.getIDCardTypeByIDCard_NO(idcard_no);
		} catch (Exception e) {
			System.err.println("ไม่พบประเภทบัตร?");
		}
		statelessperson.setIdcardtype(idcardtype);

		return statelessperson;
	}
}
