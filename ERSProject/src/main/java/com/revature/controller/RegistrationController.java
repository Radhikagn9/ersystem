package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.service.EmployeeService;
import com.revature.service.RequestService;

public class RegistrationController implements RegistrationControllerInterface{

	private static RegistrationControllerInterface registerController = new RegistrationController();


	private RegistrationController() {}


	public static RegistrationControllerInterface getInstance() {
		return registerController;
	}
	@Override
	public Object register(HttpServletRequest request) {
		// TODO Auto-generated method stub
		if(request.getMethod().equals("GET")) {
			return "Register.html";
		}

		Employee registeredAccount = new Employee(request.getParameter("firstName"),
				request.getParameter("lastName"),request.getParameter("Email"),
				request.getParameter("username"),request.getParameter("password"),
				request.getParameter("Role"));

		if(EmployeeService.getInstance().createEmployee(registeredAccount)) {

			if(request.getParameter("role").equals("Employee")){
				return HomeController.getInstance().EmployeeHome(request);
			}

			else if(request.getParameter("role").equals("Manager")){
				return HomeController.getInstance().ManagerHome(request);
			}
		} else {	
			return "Registration Success";
		}

		return null;

	}



	@Override
	public Object updateInformation(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return EmployeeService.getInstance().updateEmployeeInformation(new Employee(request.getParameter("firstName"),
				request.getParameter("lastName"),request.getParameter("Email"),
				request.getParameter("username"),request.getParameter("password"),
				request.getParameter("Role")));
	}


	@Override
	public Object viewEmployees(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return EmployeeService.getInstance().getEmployeeInformation();

	}


	@Override
	public Object insertRequests(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}



}
