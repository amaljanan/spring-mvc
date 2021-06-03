package com.pits.trainingmvc;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pits.trainingmvc.model.Product;
import com.pits.trainingmvc.service.UserService;
import com.pits.trainingmvc.service.ProductService;

@Controller
public class CreateUserController {

	@Autowired
	private UserService userCreateservice;
	@Autowired
	private ProductService viewProductsService;
	private Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/create_user")
	public ModelAndView userCreatePage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView modelandview = new ModelAndView();
		logger.info("Inside user create controller");
		List<String> departmentList = viewProductsService.getDepartments();
		modelandview.setViewName("user_registration.jsp");
		modelandview.addObject("dlist", departmentList);

		return modelandview;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create_user")
	public ModelAndView userCreate(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("radios") int role, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @RequestParam("departmentList") List<String> departmentList) {

		logger.info("Inside user create controller POST");
		ModelAndView modelandview = new ModelAndView();

		if (role == 1)
			departmentList = null;

		if (userCreateservice.userCreate(username, password, role, departmentList))
			modelandview.setViewName("userCreated.jsp");
		else
			modelandview.setViewName("user_registration.jsp");

		return modelandview;

	}

}
