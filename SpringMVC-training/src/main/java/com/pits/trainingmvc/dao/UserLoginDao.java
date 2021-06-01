package com.pits.trainingmvc.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.LoginController;
import com.pits.trainingmvc.model.User;

public class UserLoginDao {
	private Logger logger = Logger.getLogger(LoginController.class);
	public User validateUser(User user) {

		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String u = "test";
		String p = "password";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement("select * from user where uname=? and normal_pass=?");
			pst.setString(1, user.getUser_name());
			pst.setString(2, user.getPassword());

			ResultSet resultSet = pst.executeQuery();

			User resultUser = new User();

			while (resultSet.next()) {

				resultUser.setUser_name(resultSet.getString("uname"));
				resultUser.setPassword(resultSet.getString("normal_pass"));
				resultUser.setRole(resultSet.getInt("role"));
				resultUser.setDepartment(resultSet.getString("department"));
				
				logger.info("Found user !!");
				return resultUser;
			}
		}

		catch (Exception e) {
			logger.error("Exception occured in finding user"+e);;
		}
		logger.warn("No such record exist");
		return null;
	}

}
