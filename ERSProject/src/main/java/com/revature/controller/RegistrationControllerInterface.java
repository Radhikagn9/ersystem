package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public interface RegistrationControllerInterface {
	
	public Object register(HttpServletRequest request);
	public Object insertRequests(HttpServletRequest request);
	public Object updateInformation(HttpServletRequest request);
	public Object viewEmployees(HttpServletRequest request);
	
	}
