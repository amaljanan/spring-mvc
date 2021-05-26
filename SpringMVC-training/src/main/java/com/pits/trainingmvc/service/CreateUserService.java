package com.pits.trainingmvc.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;

@Service
public class CreateUserService {

	public boolean userCreate(String username, String password, int role) {
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String u = "test";
		String p = "password";
		String sqlquery;
		String admin_name = "";

		if (role == 1) {
			sqlquery = "insert into user(uname,normal_pass,role) values(?,?,?)";
			admin_name = username + "@pits.com";
		} else {
			sqlquery = "insert into user(uname,normal_pass,role) values(?,?,?)";
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement(sqlquery);
			
				pst.setString(1, username);
				pst.setString(2, password);
				pst.setInt(3, role);
				
				if(role==1)
					pst.setString(1, admin_name);
			
				pst.executeUpdate();
				pst.close();

			return true;

		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

}
