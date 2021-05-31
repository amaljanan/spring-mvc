package com.pits.trainingmvc.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.model.Product;
import com.pits.trainingmvc.model.User;

public class ViewProductsDao {
	
	public List<Product> viewProducts(User user)
	{
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String u = "test";
		String p = "password";

		List<Product> productlist = null;
		Product product = null;
		String sqlquery = null;
		ResultSet rs = null;
		
		if(user.getDepartment().equals("all"))
			sqlquery = "select * from product";
		else
			sqlquery = "select * from product where department=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement(sqlquery);
			
			if(!user.getDepartment().equals("all"))
			pst.setString(1, user.getDepartment());
			
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
	
	
	  public List<String> viewDepartments() { 
		  
		  String url = "jdbc:mysql://127.0.0.1:3306/test";
			String u = "test";
			String p = "password";

			List<String> departmentlist = null;
			Product product = null;
			String sqlquery = null;
			ResultSet rs = null;
			
			
				sqlquery = "select distinct department from product";
		
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = (Connection) DriverManager.getConnection(url, u, p);
				PreparedStatement pst = con.prepareStatement(sqlquery);
				
				rs = pst.executeQuery();
				departmentlist = new ArrayList<>();

				while (rs.next()) {

					departmentlist.add(rs.getString("department"));

				}
			}

			catch (Exception e) {
				System.out.println(e);
			}

			return departmentlist;
		  
	  }
	 
}
