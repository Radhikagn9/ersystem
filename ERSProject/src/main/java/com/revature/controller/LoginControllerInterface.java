/**
 * 
 */
package com.revature.controller;

import javax.servlet.http.*;

public interface LoginControllerInterface {
	
	public Object login(HttpServletRequest request);
	public String logout(HttpServletRequest request);
	public Object viewAccount(HttpServletRequest request);

}
