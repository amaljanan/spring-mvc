package com.pits.trainingmvc;

import java.util.Arrays;
import java.util.List;

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
import com.pits.trainingmvc.service.CreateUserService;
import com.pits.trainingmvc.service.ViewProductsService;

@Controller
public class CreateUserController {

	@Autowired
	private CreateUserService userCreateservice;
	@Autowired
	private ViewProductsService viewProductsService;

	@RequestMapping(method = RequestMethod.GET, value = "/create_user")
	public ModelAndView userCreatePage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView modelandview = new ModelAndView();
		List<String> departmentList = viewProductsService.fetchDepartments();
		modelandview.setViewName("user_registration.jsp");
		modelandview.addObject("dlist", departmentList);

		return modelandview;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create_user")
	public ModelAndView userCreate(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("radios") int role, @RequestParam("departmentN") String departmentN,
			@RequestParam("departmentA") String departmentA, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		ModelAndView modelandview = new ModelAndView();

		String department = (role == 1) ? departmentA : departmentN;

		if (session.getAttribute("user") != null
				&& userCreateservice.userCreate(username, password, role, department)) {
			modelandview.setViewName("userCreated.jsp");

		} else {
			modelandview.setViewName("AdminUser.jsp");
		}
		return modelandview;

	}

}
