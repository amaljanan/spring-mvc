package com.pits.trainingmvc.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;
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
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String u = "test";
		String p = "password";

		List<Product> plist = null;
		Product product = null;

		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement("select * from product");

			rs = pst.executeQuery();
			plist = new ArrayList<Product>();

			while (rs.next()) {

				product = new Product();
				product.setProduct_name(rs.getString("product_name"));
				product.setPrice(rs.getString("price"));
				plist.add(product);

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return plist;
	}

}
