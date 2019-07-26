package com.revature.service;

import java.util.List;

import com.revature.model.Request;

public interface RequestInterface {
	
	public List<Request> listAllRequests();
	public boolean insertingRequests(Request request);
	public List<Request> listAllPendingRequests();
	public List<Request> listAllResolvedRequests();
	public Request listPendingRequestsbyID(Request request);
	public Request listResolvedRequestsbyID(Request request);
	public Request listRequestbyID(Request request);
	public boolean updatingRequests(Request request);
}



