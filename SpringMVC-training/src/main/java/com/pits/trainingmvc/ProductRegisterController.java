package com.pits.trainingmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pits.trainingmvc.service.ProductService;

@Controller
public class ProductRegisterController {

	@Autowired
	private ProductService productService;
	private Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(method = RequestMethod.POST, value = "/product_register")
	public ModelAndView productRegister(@RequestParam("product_name") String productName,
			@RequestParam("price") String price, @RequestParam("department") String department,
			@RequestParam("stocksAvailable") int stocksAvailable, HttpServletRequest request, HttpSession session) {
		ModelAndView modelandview = new ModelAndView();

		logger.info("Inside Product Register Controller");
		if (session.getAttribute("user") != null
				&& productService.productRegister(productName, price, department, stocksAvailable)) {
			modelandview.setViewName("product_registered.jsp");
		} else {
			modelandview.setViewName("product_register.jsp");
		}
		return modelandview;
	}

}
