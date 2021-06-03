package com.pits.trainingmvc.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;
import com.pits.trainingmvc.dao.CreateUserDao;
import com.pits.trainingmvc.model.User;

@Service
public class UserService {
	@Autowired
	private CreateUserDao createUserDao;

	public boolean userCreate(String username, String password, int role, List<String> departmentList) {

		User user = new User();
		user.setUser_name(username);
		user.setPassword(password);
		user.setRole(role);
		user.setDepartmentList(departmentList);

		return createUserDao.CreateUser(user);
	}

}
