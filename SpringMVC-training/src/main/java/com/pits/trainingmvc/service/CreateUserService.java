package com.pits.trainingmvc.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.dao.CreateUserDao;
import com.pits.trainingmvc.model.User;

@Service
public class CreateUserService {

	public boolean userCreate(String username, String password, int role) {
		
		User user = new User();
			user.setUser_name(username);
			user.setPassword(password);
			user.setRole(role);
			
		CreateUserDao createUserDao = new CreateUserDao();
		
		return createUserDao.CreateUser(user);
	}

}
