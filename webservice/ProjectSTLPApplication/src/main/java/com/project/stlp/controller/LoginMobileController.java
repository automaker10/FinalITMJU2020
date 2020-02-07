package com.project.stlp.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.stlp.entity.Login;
import com.project.stlp.repository.LoginRepository;
import com.project.stlp.repository.RequestForHelpRepository;
import com.project.stlp.util.PasswordUtil;
import com.project.stlp.util.ResponseObj;


@Controller
@RequestMapping(path = "/loginmobile")
public class LoginMobileController {

	@Autowired
	LoginRepository mAddLoginRepository;
	
	@Autowired
	RequestForHelpRepository mRequestnRepository;
	
	private static String SALT = "123456";

	@PostMapping(path = "/login")
	public @ResponseBody ResponseObj verifyLogin(@RequestBody List<String> map)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, ParseException {
		String username = map.get(0);
		String password = map.get(1);
		
		Login user = new Login();
		user.setUsername(username);
		user.setPassword(PasswordUtil.getInstance().createPassword(password, SALT));
		Login queryUser = mAddLoginRepository.login(user.getUsername(), user.getPassword());

		if (queryUser == null)
			return new ResponseObj(500, "ชื่อผู้ใช้งานหรือรหัสผ่านไม่ถูกต้อง?");

		return new ResponseObj(200, queryUser);
	}

}
