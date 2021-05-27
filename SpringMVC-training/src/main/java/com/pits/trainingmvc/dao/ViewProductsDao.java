package com.pits.trainingmvc.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.model.Product;

public class ViewProductsDao {
	
	public List<Product> viewProducts()
	{
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String u = "test";
		String p = "password";

		List<Product> productlist = null;
		Product product = null;

		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement("select * from product");

			rs = pst.executeQuery();
			productlist = new ArrayList<Product>();

			while (rs.next()) {

				product = new Product();
				product.setProduct_name(rs.getString("product_name"));
				product.setPrice(rs.getString("price"));
				productlist.add(product);

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return productlist;
	}

}
