package com.revature.service;

import java.util.List;

import com.revature.model.Request;
import com.revature.repository.RequestRepositoryJdbc;

public class RequestService implements RequestInterface{
	
	private static RequestInterface requestService = new RequestService();

	private RequestService() { }

	public static RequestInterface getInstance() {
		return requestService;
	}


	@Override
	public List<Request> listAllRequests() {
		// TODO Auto-generated method stub
		return RequestRepositoryJdbc.getInstance2().viewRequest();
		
	}

	@Override
	public boolean insertingRequests(Request request) {
		// TODO Auto-generated method stub
		return RequestRepositoryJdbc.getInstance2().insertRequest(request);
		
	}
	
	@Override
	public Request listRequestbyID(Request request) {
		return  RequestRepositoryJdbc.getInstance2().lookAtRequestByEmployee(request);
	}

	

	@Override
	public List<Request> listAllResolvedRequests() {
		return  RequestRepositoryJdbc.getInstance2().lookAtResolvedRequests();
	}

	@Override
	public Request listPendingRequestsbyID(Request request) {
		return  RequestRepositoryJdbc.getInstance2().lookAtPendingRequestByID(request);
	}

	
	@Override
	public boolean updatingRequests(Request request) {
		return RequestRepositoryJdbc.getInstance2().updateRequest(request);
	}

	@Override
	public List<Request> listAllPendingRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Request listResolvedRequestsbyID(Request request) {
		// TODO Auto-generated method stub
		return null;
	}

}
