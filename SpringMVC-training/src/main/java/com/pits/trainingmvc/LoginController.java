package com.pits.trainingmvc;

import org.apache.log4j.Logger;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pits.trainingmvc.model.Product;
import com.pits.trainingmvc.model.User;
import com.pits.trainingmvc.service.LoginService;
import com.pits.trainingmvc.service.ProductService;
import java.util.*;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private ProductService viewProductService;

	private Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpSession session) {
		ModelAndView modelandview = new ModelAndView();

		User user = (User) session.getAttribute("user");

		if (user != null && user.getRole() == 1) {
			modelandview.setViewName("AdminUser.jsp");
			modelandview.addObject("username", user.getUser_name().split("\\@")[0]);
		} else if (user != null && user.getRole() == 0) {
			modelandview.setViewName("NormalUser.jsp");
			modelandview.addObject("username", user.getUser_name());

		} else
			modelandview.setViewName("index.jsp");
		logger.info("This Is A Login Controller Entry ......!");

		return modelandview;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ModelAndView loginCheck(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		ModelAndView modelandview = new ModelAndView();

		logger.info("This Is A Login Form Check Entry ......!");

		User user = loginService.logincheck(username, password);

		if (user == null) {
			modelandview.setViewName("index.jsp");
			modelandview.addObject("errorMessage", "Wrong username or Password!!!");
			logger.error("Entered username or password is Wrong");
		} else if (user.getRole() == 1) {

			session.setAttribute("user", user);
			modelandview.setViewName("AdminUser.jsp");
			modelandview.addObject("username", user.getUser_name().split("\\@")[0]);

		} else if (user.getRole() == 0) {
			session.setAttribute("user", user);
			modelandview.setViewName("NormalUser.jsp");
			modelandview.addObject("username", user.getUser_name());
		}

		else {
			modelandview.setViewName("index.jsp");

		}

		return modelandview;
	}

}
