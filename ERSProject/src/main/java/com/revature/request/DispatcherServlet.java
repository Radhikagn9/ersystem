package com.revature.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DispatcherServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5244611926643604805L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException{
		
		Object data = RequestHelper.process(request);
		
		if(data instanceof String) {
			String URI = (String) data;
			request.getRequestDispatcher(URI).forward(request, response);
			
			}
		
		//else, marshal the given POJO
		
		else {
			response.getWriter().write(new ObjectMapper().writeValueAsString(data));
		}
		
		
		
		//Customer loggedCustomer = CustomerServiceAlpha.getInstance().authenticate(
		//   newCustomer(request.getParameter("username"),request.getParameter("password")));
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException{
		
		doGet(request,response);
		
		
	}

}
