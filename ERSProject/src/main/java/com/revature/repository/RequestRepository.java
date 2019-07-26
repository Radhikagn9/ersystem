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
	public List<Request> lookAtPendingRequests();
	public List<Request> lookAtResolvedRequests();
	public List<Request> viewRequest();
	public Request viewRequestByEmployee(long r_id);
	public List<Request> lookAtRequest();
	public Request lookAtRequestByEmployee(Request request);
	public Request lookAtPendingRequestByID(Request request);
	public Request lookAtResolvedRequestsByID(Request request);
	public boolean updateRequest (Request request);
	Request lookAtRequestByEmployee(long rID);

}
