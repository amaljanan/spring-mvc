package com.pits.trainingmvc.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;

@Service
public class LoginService {

	public String logincheck(String username, String password) {
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String u = "test";
		String p = "password";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement("select normal_pass,role from user where uname=?");
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				if (rs.getString("role").equals("1") && rs.getString("normal_pass").equals(password))
					return "Admin";
				else if(rs.getString("role").equals("0") && rs.getString("normal_pass").equals(password))
						return "Normal";
				else
					 	return "";

			}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return "";
	}


}
