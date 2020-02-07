package com.project.stlp.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.stlp.entity.Login;
import com.project.stlp.repository.CenterRepository;
import com.project.stlp.repository.LoginRepository;
import com.project.stlp.repository.StaffRepository;
import com.project.stlp.util.PasswordUtil;

@Controller
@RequestMapping(path = "/")
public class LoginWebController {

	@Autowired
	LoginRepository mAddLoginRepository;

	@Autowired
	StaffRepository staffRepository;
	private static String SALT = "123456";

	@Autowired
	CenterRepository centerRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView loginview() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public ModelAndView verifyLogin(@RequestParam("username") String username, 
			@RequestParam("password") String password,HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		ModelAndView model = new ModelAndView("login");
		ModelAndView modelwelcome = new ModelAndView("welcome");
		Login user = new Login();
		user.setUsername(username);
		user.setPassword(PasswordUtil.getInstance().createPassword(password, SALT));

		Login queryUser = mAddLoginRepository.login(user.getUsername(), user.getPassword());
		if (queryUser != null && queryUser.getType()!=2 && queryUser.getType() !=1) {
			modelwelcome.addObject("username", queryUser.getUsername());
			modelwelcome.addObject("password", password);
			modelwelcome.addObject("typeuser", queryUser.getType());
			modelwelcome.addObject("president", staffRepository.getStaffByUsername(username));
			HttpSession session = request.getSession();
			session.setAttribute("usernamesession", username);
			session.setMaxInactiveInterval(1000);
		
			return modelwelcome;
		} else {
			model.addObject("danger", "ชื่อผู้ใช้งานหรือรหัสผ่านไม่ถูกต้อง!!");
			return model;
		}

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logOut(HttpSession session){
		ModelAndView model = new ModelAndView("login");
		session.removeAttribute("usernamesession");
		session.setMaxInactiveInterval(0);
		return model;

	}
}
