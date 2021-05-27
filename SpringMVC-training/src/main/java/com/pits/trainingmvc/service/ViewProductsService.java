package com.pits.trainingmvc.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.dao.ViewProductsDao;
import com.pits.trainingmvc.model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class ViewProductsService {

	public List<Product> viewProducts() {
		
		ViewProductsDao viewProductDao = new ViewProductsDao();
		
		List<Product> productlist = viewProductDao.viewProducts();
		
		return productlist;
	}

}
