package com.pits.trainingmvc.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.dao.CreateUserDao;
import com.pits.trainingmvc.model.User;

@Service
public class UserService {
	@Autowired
	private CreateUserDao createUserDao;

	public boolean userCreate(String username, String password, int role, String department) {

		User user = new User();
		user.setUser_name(username);
		user.setPassword(password);
		user.setRole(role);
		user.setDepartment(department);

		return createUserDao.CreateUser(user);
	}

}
