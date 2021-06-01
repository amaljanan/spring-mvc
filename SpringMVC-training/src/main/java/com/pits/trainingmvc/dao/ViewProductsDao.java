package com.pits.trainingmvc.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.LoginController;
import com.pits.trainingmvc.model.Product;
import com.pits.trainingmvc.model.User;

public class ViewProductsDao {
	private Logger logger = Logger.getLogger(LoginController.class);
	public List<Product> viewProducts(User user) {
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String u = "test";
		String p = "password";

		List<Product> productlist = null;
		Product product = null;
		String sqlquery = null;
		ResultSet resultSet = null;

		if (user.getDepartment().equals("all"))
			sqlquery = "select * from product";
		else
			sqlquery = "select * from product where department=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement(sqlquery);

			if (!user.getDepartment().equals("all"))
				pst.setString(1, user.getDepartment());

			resultSet = pst.executeQuery();
			productlist = new ArrayList<Product>();

			while (resultSet.next()) {

				product = new Product();
				product.setProduct_name(resultSet.getString("product_name"));
				product.setPrice(resultSet.getString("price"));
				product.setDepartment(resultSet.getString("department"));
				product.setStocksAvailable(resultSet.getInt("stocksAvailable"));
				productlist.add(product);
				
				logger.info("Product details storing in list");
			}
		}

		catch (Exception e) {
			logger.error("Exception occured while fetching products !!"+e);;
		}

		return productlist;
	}

	public List<String> viewDepartments() {

		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String u = "test";
		String p = "password";

		List<String> departmentList = null;
		String sqlquery = null;
		ResultSet resultSet = null;

		sqlquery = "select distinct department from product";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement(sqlquery);

			resultSet = pst.executeQuery();
			departmentList = new ArrayList<>();

			while (resultSet.next()) {

				departmentList.add(resultSet.getString("department"));

			}
		}

		catch (Exception e) {
			logger.error("Exception occured while fetching departments !! "+e);;
		}

		return departmentList;

	}

}
