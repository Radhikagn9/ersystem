/**
 * 
 */
package com.revature.repository;

import java.util.List;

import com.revature.model.Request;

/**
 * @author Radhika 
 *
 */
public interface RequestRepository {
	
	public boolean insertRequest(Request request);
	public List<Request> viewRequest();
	public Request viewRequestByEmployee(long r_id);
	public boolean updateRequest(Request request);
	
	

}
