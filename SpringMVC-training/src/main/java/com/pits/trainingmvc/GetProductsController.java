package com.pits.trainingmvc;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.pits.trainingmvc.model.Product;
import com.pits.trainingmvc.model.User;

import java.util.ArrayList;
import java.util.List;

import com.pits.trainingmvc.service.ProductService;

@Controller
public class GetProductsController {

	@Autowired
	ProductService viewProductService;
	private Logger logger = Logger.getLogger(LoginController.class);
	@RequestMapping(method = RequestMethod.GET, value = "/view_products")
	public ModelAndView getProducts(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView modelandview = new ModelAndView();

		User user = (User) session.getAttribute("user");
		logger.info("Inside get Products Controller");
		if (user != null) {
			List<Product> productList = viewProductService.getProducts(user);

			modelandview.setViewName("view_products.jsp");

			modelandview.addObject("productList", productList);
		} else {
			modelandview.setViewName("index.jsp");
		}
		return modelandview;
	}

}
