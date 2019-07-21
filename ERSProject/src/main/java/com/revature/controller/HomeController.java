package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;

public class HomeController implements HomeControllerInterface{
	
	private static HomeControllerInterface homecontroller = new HomeController();
	
	private HomeController() {}
	
	public static HomeControllerInterface getInstance() {
		return homecontroller;
		
	}

	@Override
	public String EmployeeHome(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Employee loggedInAccount = (Employee)request.getSession().getAttribute("loggedIn");
		
		if(loggedInAccount == null) {
			return "Login.html";
		}
		
		return "EmployeeHomePage.html";
	}

	@Override
	public String ManagerHome(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Employee loggedInAccount = (Employee)request.getSession().getAttribute("loggedIn");
		
		if(loggedInAccount== null) {
			return "Login.html";
		}
		return "ManagerHomePage.html";
	}

	
	
	
	
	

}
