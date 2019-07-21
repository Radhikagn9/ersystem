package com.revature.service;

import java.util.Set;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.model.ReimbursementType;
import com.revature.repository.ReimbursementRepositoryJdbc;

public class ReimbursementService implements ReimbursementServiceInterface{

	private static Logger logger = Logger.getLogger(ReimbursementService.class);


	private static ReimbursementServiceInterface reimbursementservice = new ReimbursementService();

	private ReimbursementService() {}


	public static ReimbursementServiceInterface getInstance() {
		return reimbursementservice;
	}







	@Override
	public boolean submitRequest(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean finalizeRequest(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reimbursement getSingleRequest(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Reimbursement> getUserPendingRequests(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Reimbursement> getUserFinalizedRequests(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Reimbursement> getAllPendingRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Reimbursement> getAllResolvedRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ReimbursementType> getReimbursementTypes() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insertReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub

		//new ReimbursementRepositoryJdbc.insert(reimbursement);
		

	}


	@Override
	public void updateReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		new ReimbursementRepositoryJdbc().update(reimbursement);

	}


	@Override
	public List<String> getTypes() {
		// TODO Auto-generated method stub

		return new ReimbursementRepositoryJdbc().getTypes();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
