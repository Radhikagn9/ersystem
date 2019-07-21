package com.revature.service;

import java.util.List;

import com.revature.model.Request;
import com.revature.repository.RequestRepositoryJdbc;

public class RequestService implements RequestInterface{

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

}
