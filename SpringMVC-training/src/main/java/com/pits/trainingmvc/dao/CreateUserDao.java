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

		sqlquery = "insert into user(uname,normal_pass,role) values(?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement(sqlquery);

			pst.setString(1, user.getUser_name());
			pst.setString(2, user.getPassword());
			pst.setInt(3, user.getRole());

			if (user.getRole() == 1)
				pst.setString(1, user.getUser_name() + "@pits.com");

			pst.executeUpdate();
			pst.close();

			if (user.getRole() == 0)
				CreateUserDao.departmentadd(user);

			logger.info("Successfully created user");
			return true;

		} catch (Exception e) {

			logger.error("Exception occured during creation of user ......!" + e);

		}

		return false;
	}

	private static boolean departmentadd(User user) {
		System.out.println("Inside Static fun");
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String u = "test";
		String p = "password";
		StringBuffer sqldepartment = new StringBuffer("insert into departments (username, department) values (?, ?)");

		for (int i = 0; i < user.getDepartmentList().size() - 1; i++) {
			sqldepartment.append(", (?, ?)");
		}
		System.out.println(sqldepartment.toString());

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, u, p);
			PreparedStatement pst = con.prepareStatement(sqldepartment.toString());

			int k = 0;

			for (int i = 0; i < user.getDepartmentList().size(); i++) {
				pst.setString(++k, user.getUser_name());
				pst.setString(++k, user.getDepartmentList().get(i));
			}

			pst.executeUpdate();
			pst.close();

			return true;

		} catch (Exception e) {

			System.out.println(e);
			;

		}

		return false;
	}

}
