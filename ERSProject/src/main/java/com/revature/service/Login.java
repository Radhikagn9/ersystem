package com.revature.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.model.Employee;
import com.revature.repository.EmployeeRepositoryJdbc;
import com.revature.util.ConnectionUtil;

public class Login {
	
	private static Logger logger = Logger.getLogger(Login.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		login(null);
	}
	
	public static int login(Employee employee) {
		try {
			Connection connection = ConnectionUtil.getConnection();
			int statementIndex = 0;
		String command = "SELECT U_USERNAME, U_PASSWORD FROM USER_T WHERE U_USERNAME=? AND U_PASSWORD=?";
		PreparedStatement statement = connection.prepareStatement(command);
		statement.setString(++statementIndex,employee.getUsername());
		statement.setString(++statementIndex,employee.getPassword());
		ResultSet result = statement.executeQuery();
		if(result.next()) {
			logger.info("You are signed in: ");
		}
		
		else logger.error("Invalid Username/Password.");
	} catch (SQLException e) {
		
		logger.error("Invalid Username/Password.",e);
	}
	return 0;
	}
	
		

		

	}


