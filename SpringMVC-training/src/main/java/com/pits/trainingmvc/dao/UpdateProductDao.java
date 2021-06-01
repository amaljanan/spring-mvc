package com.pits.trainingmvc.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.LoginController;
import com.pits.trainingmvc.model.Product;
import com.pits.trainingmvc.model.User;

public class UpdateProductDao {

	private Logger logger = Logger.getLogger(LoginController.class);
	public boolean updateProduct(String productName, String price, int stocksAvailable) {
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String u = "test";
		String p = "password";

		String sqlquery = null;
		
			sqlquery = "update product set price=?, stocksAvailable=? where product_name=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement(sqlquery);
			pst.setString(1, price);
			pst.setInt(2, stocksAvailable);
			pst.setString(3, productName);
			pst.executeUpdate();
			
			return true;
			
		}

		catch (Exception e) {
			logger.error("Exception occured while updating product !!"+e);;
		}

		return false;
	}

}
