package com.pits.trainingmvc.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.dao.UserLoginDao;
import com.pits.trainingmvc.model.User;

@Service
public class LoginService {
	@Autowired
	private UserLoginDao userLoginDao;

	public User logincheck(String username, String password) {

		User user = new User();

		user.setUser_name(username);
		user.setPassword(password);

		return userLoginDao.validateUser(user);
	}

}
