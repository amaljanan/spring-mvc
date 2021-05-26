package com.pits.trainingmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pits.trainingmvc.service.CreateUserService;

@Controller
public class CreateUserController {

	@Autowired
	private CreateUserService userCreateservice;

	@RequestMapping(method = RequestMethod.POST, value = "/create_user")
	public ModelAndView userCreate(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("radios") int role, HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelandview = new ModelAndView();

		HttpSession session = request.getSession();

		if (session.getAttribute("username") != null && userCreateservice.userCreate(username, password, role)) {
			modelandview.setViewName("userCreated.jsp");

		} else {
			modelandview.setViewName("AdminUser.jsp");
		}
		return modelandview;

	}

}
