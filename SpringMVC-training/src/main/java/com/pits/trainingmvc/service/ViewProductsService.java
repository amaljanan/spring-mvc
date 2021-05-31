package com.pits.trainingmvc.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.dao.ViewProductsDao;
import com.pits.trainingmvc.model.Product;
import com.pits.trainingmvc.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class ViewProductsService {
	@Autowired
	private ViewProductsDao viewProductDao;

	public List<Product> viewProducts(User user) {

		List<Product> productlist = viewProductDao.viewProducts(user);

		return productlist;
	}

	public List<String> fetchDepartments() {

		List<String> productlist = viewProductDao.viewDepartments();
		return productlist;

	}

}
