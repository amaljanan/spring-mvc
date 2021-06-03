package com.pits.trainingmvc.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.LoginController;
import com.pits.trainingmvc.model.Product;

public class ProductRegisterDao {
	private Logger logger = Logger.getLogger(LoginController.class);

	public boolean productRegister(Product product) {

		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String u = "test";
		String p = "password";
		String sqlquery;

		sqlquery = "insert into product(product_name,price,department,stocksAvailable) values(?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement(sqlquery);

			pst.setString(1, product.getProduct_name());
			pst.setString(2, product.getPrice());
			pst.setString(3, product.getDepartment());
			pst.setInt(4, product.getStocksAvailable());

			pst.executeUpdate();
			pst.close();

			logger.info("Successfully created Product");
			return true;

		} catch (Exception e) {
			logger.error("Exception occured while creating product ......!" + e);
		}

		return false;
	}

}
