package com.pits.trainingmvc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	private Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelandview = new ModelAndView();

		logger.info("Inside logout controller");
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();

		modelandview.setViewName("index.jsp");

		return modelandview;

	}
}
