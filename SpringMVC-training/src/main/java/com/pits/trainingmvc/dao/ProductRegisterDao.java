package com.pits.trainingmvc.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.model.Product;

public class ProductRegisterDao {

	public boolean productRegister(Product product) {

		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String u = "test";
		String p = "password";
		String sqlquery;

		sqlquery = "insert into product(product_name,price,department) values(?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement(sqlquery);

			pst.setString(1, product.getProduct_name());
			pst.setString(2, product.getPrice());
			pst.setString(3, product.getDepartment());

			pst.executeUpdate();
			pst.close();

			return true;

		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

}
