package com.pits.trainingmvc.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;

@Service
public class ProductRegisterService {
	
	public boolean productRegister(String product_name, String price) {
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String u = "test";
		String p = "password";
		String sqlquery;

		sqlquery = "insert into product(product_name,price) values(?,?)";
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement(sqlquery);
			
				pst.setString(1, product_name);
				pst.setString(2, price);
				
				pst.executeUpdate();
				pst.close();

			return true;

		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

}
