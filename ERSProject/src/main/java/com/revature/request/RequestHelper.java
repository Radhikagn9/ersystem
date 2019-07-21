package com.revature.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.revature.controller.HomeController;
import com.revature.controller.LoginController;
import com.revature.controller.RegistrationController;

public class RequestHelper {
	
	private RequestHelper() {}
	
	public static Object process(HttpServletRequest request)throws ServletException,
	IOException {
		switch(request.getRequestURI()) {
		case "/ERSProject/login.do":
			return LoginController.getInstance().login(request);
		case "/ERSProject/logout.do":
			return LoginController.getInstance().logout(request);
		case "/ERSProject/employeehome.do":
			return HomeController.getInstance().EmployeeHome(request);
		case "/ERSProject/managerhome.do":
			return HomeController.getInstance().ManagerHome(request);
		case "/ERSProject/register.do":
			return RegistrationController.getInstance().register(request);
		case "/ERSProject/ViewAllEmployees.do":
			return RegistrationController.getInstance().viewEmployees(request);
		case "/ERSProject/ViewAccount.do":
			return LoginController.getInstance().viewAccount(request);
			
			
		default:
			return "404";
		
		
		}
	}

	public static RequestHelper getRequestHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
