package com.pits.trainingmvc.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.dao.ProductRegisterDao;
import com.pits.trainingmvc.dao.ViewProductsDao;
import com.pits.trainingmvc.dao.UpdateProductDao;
import com.pits.trainingmvc.model.Product;
import com.pits.trainingmvc.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
	@Autowired
	private ViewProductsDao viewProductDao;
	@Autowired
	private ProductRegisterDao productRegisterDao;
	@Autowired
	private UpdateProductDao updateProductDao;

	public List<Product> getProducts(User user) {

		List<Product> productlist = viewProductDao.viewProducts(user);

		return productlist;
	}

	public List<String> getDepartments() {

		List<String> productlist = viewProductDao.viewDepartments();
		return productlist;

	}
	
	public boolean productRegister(String productName, String price, String department, int stocksAvailable) {

		Product product = new Product();
		product.setProduct_name(productName);
		product.setPrice(price);
		product.setDepartment(department);
		product.setStocksAvailable(stocksAvailable);

		return productRegisterDao.productRegister(product);
	}

	public boolean updateProduct(String productName, String price, int stocksAvailable) {
		
		if(updateProductDao.updateProduct(productName, price, stocksAvailable))
			return true;
		else
			return false;
		
	}
	
}
