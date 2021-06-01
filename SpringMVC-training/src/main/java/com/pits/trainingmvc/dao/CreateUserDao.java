package com.pits.trainingmvc.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.LoginController;
import com.pits.trainingmvc.model.User;

public class CreateUserDao {
	private Logger logger = Logger.getLogger(LoginController.class);
	public boolean CreateUser(User user) {

		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String u = "test";
		String p = "password";
		String sqlquery;

		sqlquery = "insert into user(uname,normal_pass,role,department) values(?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement(sqlquery);

			pst.setString(1, user.getUser_name());
			pst.setString(2, user.getPassword());
			pst.setInt(3, user.getRole());
			pst.setString(4, user.getDepartment());

			if (user.getRole() == 1)
				pst.setString(1, user.getUser_name() + "@pits.com");

			pst.executeUpdate();
			pst.close();

			logger.info("Successfully created user");
			return true;

		} catch (Exception e) {
			
			logger.error("Exception occured during creation of user ......!"+e);
			
			
		}
		return false;
	}

}
