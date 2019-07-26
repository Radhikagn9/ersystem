package com.revature.repository;

import java.util.List;

import com.revature.model.Status;

public interface StatusRepository {

	public boolean insertStatus(Status status);
	public List<Status> getStatus();

	
}
