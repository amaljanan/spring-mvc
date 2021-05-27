package com.pits.trainingmvc.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.dao.ProductRegisterDao;
import com.pits.trainingmvc.model.Product;

@Service
public class ProductRegisterService {

	public boolean productRegister(String product_name, String price) {
		
		ProductRegisterDao productRegisterDao = new ProductRegisterDao();
		
		Product product =  new Product();
		product.setProduct_name(product_name);	
		product.setPrice(price);
			
		return productRegisterDao.productRegister(product);
	}

}
