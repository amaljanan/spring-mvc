package com.pits.trainingmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pits.trainingmvc.service.ProductRegisterService;

@Controller
public class ProductRegisterController {

	@Autowired
	private ProductRegisterService productRegisterService;

	@RequestMapping(method = RequestMethod.POST, value = "/product_register")
	public ModelAndView productRegister(@RequestParam("product_name") String product_name,
			@RequestParam("price") String price, @RequestParam("department") String department,
			HttpServletRequest request, HttpSession session) {
		ModelAndView modelandview = new ModelAndView();

		if (session.getAttribute("user") != null
				&& productRegisterService.productRegister(product_name, price, department)) {
			modelandview.setViewName("product_registered.jsp");
		} else {
			modelandview.setViewName("product_register.jsp");
		}
		return modelandview;
	}

}
