package com.pits.trainingmvc.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.dao.ProductRegisterDao;
import com.pits.trainingmvc.model.Product;

@Service
public class ProductRegisterService {
	@Autowired
	private ProductRegisterDao productRegisterDao;
	
	public boolean productRegister(String product_name, String price, String department) {
		
		
		Product product =  new Product();
		product.setProduct_name(product_name);	
		product.setPrice(price);
		product.setDepartment(department);
			
		return productRegisterDao.productRegister(product);
	}

}
