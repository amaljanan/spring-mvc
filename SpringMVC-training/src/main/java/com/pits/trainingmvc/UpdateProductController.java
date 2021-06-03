package com.pits.trainingmvc;

import java.io.IOException;

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

import com.pits.trainingmvc.service.ProductService;

@Controller
public class UpdateProductController {
	@Autowired
	private ProductService productService;
	private Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/update_product")
	public ModelAndView updateProductPage(@RequestParam("productName") String productName, HttpServletRequest request,
			HttpSession session) {
		ModelAndView modelandview = new ModelAndView();

		logger.info("Inside update Product Controller");

		modelandview.setViewName("update_product.jsp");
		modelandview.addObject("productName", productName);
		return modelandview;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update_product")
	public ModelAndView updateProduct(@RequestParam("productName") String productName,
			@RequestParam("price") String price, @RequestParam("stocksAvailable") int stocksAvailable,
			HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException {

		logger.info("Product updating ....");

		if (productService.updateProduct(productName, price, stocksAvailable))
			return new ModelAndView("redirect:/view_products");
		else
			return new ModelAndView("redirect:/update_product");

	}

}
