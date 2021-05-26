package com.pits.trainingmvc;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.pits.trainingmvc.model.Product;

import java.util.ArrayList;
import java.util.List;

import com.pits.trainingmvc.service.ViewProductsService;

@Controller
public class ViewProductsController {
	
	@Autowired
	ViewProductsService viewProductService;
	
	@RequestMapping(method = RequestMethod.GET, value ="/view_products" )
	public ModelAndView viewProducts(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView modelandview = new ModelAndView();
		
		
		List<Product> productlist = viewProductService.viewProducts();
		
		modelandview.setViewName("view_products.jsp");
		
		modelandview.addObject("plist",productlist);
		
		return modelandview;
	}
	
}
