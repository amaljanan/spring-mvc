package com.pits.trainingmvc.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.dao.UserLoginDao;
import com.pits.trainingmvc.model.User;

@Service
public class LoginService {

	public User logincheck(String username, String password) {

		UserLoginDao userLoginDao = new UserLoginDao();

		User user = new User();

		user.setUser_name(username);
		user.setPassword(password);

		return userLoginDao.validateUser(user);
	}

}
