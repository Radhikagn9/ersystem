package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class LoginController implements LoginControllerInterface{
	
	private static LoginControllerInterface logincontroller = new LoginController();
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	private LoginController() {}
	
	public static LoginControllerInterface getInstance() {
		return logincontroller;
	}

	@Override
	public Object login(HttpServletRequest request) {
		if(request.getMethod().equals("GET")) {
			return "Login.html";
		}
		
	Employee loggedIn = EmployeeService.getInstance().getEmployeeInformation(new Employee(0,null,null,null,
			request.getParameter("username"),request.getParameter("password"),
			request.getParameter("role")));
	
	logger.trace("Logging in");
	
	if(loggedIn==null) {
		logger.warn("Unable to sign in");
		return "Authentication failed";
	}
	
	logger.info("You are signed in");
	request.getSession().setAttribute("loggedIn",loggedIn);
	
	if(request.getParameter("role").equals("Employee")) {
		return HomeController.getInstance().EmployeeHome(request);
	}
	
	else if(request.getParameter("role").equals("Manager")) {
		return HomeController.getInstance().ManagerHome(request);
	}

	return null;
	}
	

	@Override
	public String logout(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		return "Login.html";
		
	}

	@Override
	public Object viewAccount(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	Employee loggedIn = EmployeeService.getInstance().getEmployeeInformation(new Employee(null,
			null,null,request.getParameter("username"),request.getParameter("password"),
				request.getParameter("role")));
		
		return request.getSession().getAttribute("loggedIn");
	}

}
