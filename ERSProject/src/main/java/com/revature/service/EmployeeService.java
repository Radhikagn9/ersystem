package com.revature.service;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.model.Employee;
import com.revature.model.EmployeeToken;
import com.revature.repository.EmployeeRepository;
import com.revature.repository.EmployeeRepositoryJdbc;

public class EmployeeService implements EmployeeServiceInterface{

	private static Logger logger = Logger.getLogger(EmployeeService.class);
	
	private static EmployeeServiceInterface employeeservice = new EmployeeService();
		
	private EmployeeService() {}
	
	
	public static EmployeeServiceInterface getInstance() {
		return employeeservice;
	}
	
	@Override
	public com.revature.model.Employee authenticate(com.revature.model.Employee employee) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Employee getEmployeeInformation(Employee employee) {
		Employee loggedInAccount = EmployeeRepositoryJdbc.getInstance().select(employee);
		
		if((loggedInAccount.getUsername().equals(employee.getUsername()) &&
				(loggedInAccount.getPassword().equals(employee.getPassword())))) {
			
			return loggedInAccount;
		}
		
		return null;
	}

	@Override
	public List<Employee> getAllEmployeesInformation() {
		// TODO Auto-generated method stub
		return EmployeeRepositoryJdbc.getInstance().selectAll();
		
	}

	@Override
	public boolean createEmployee(com.revature.model.Employee employee) {
		// TODO Auto-generated method stub
		return EmployeeRepositoryJdbc.getInstance().insert(employee);
		
	}

	@Override
	public boolean updateEmployeeInformation(com.revature.model.Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePassword(com.revature.model.Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUsernameTaken(com.revature.model.Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createPasswordToken(com.revature.model.Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePasswordToken(EmployeeToken employeeToken) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTokenExpired(EmployeeToken employeeToken) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Employee checkAccount(Employee employee) {
		Employee loggedInAccount = EmployeeRepositoryJdbc.getInstance().select(employee);
		
		if((loggedInAccount.getUsername().equals(employee.getUsername())&&
				(loggedInAccount.getPassword().equals(employee.getPassword())))){
			
			return loggedInAccount;
		}
		return null;
	}


	@Override
	public Object getEmployeeInformation() {
		// TODO Auto-generated method stub
		return null;
	}

}
