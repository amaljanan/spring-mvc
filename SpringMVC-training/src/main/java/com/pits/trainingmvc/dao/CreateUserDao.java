package com.pits.trainingmvc.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.model.User;

public class CreateUserDao {

	public boolean CreateUser(User user)
	{
		
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String u = "test";
		String p = "password";
		String sqlquery;
		
		sqlquery = "insert into user(uname,normal_pass,role) values(?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement(sqlquery);
			
				pst.setString(1, user.getUser_name());
				pst.setString(2, user.getPassword());
				pst.setInt(3, user.getRole());
				
				if(user.getRole()==1)
					pst.setString(1, user.getUser_name()+"@pits.com");
			
				pst.executeUpdate();
				pst.close();

			return true;

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
}
