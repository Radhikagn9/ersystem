package com.revature.service;

import java.util.List;

import com.revature.model.Request;

public interface RequestInterface {
	
	public List<Request> listAllRequests();
	public boolean insertingRequests(Request request);
}



