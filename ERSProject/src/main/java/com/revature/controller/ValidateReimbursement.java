package com.revature.controller;

import java.util.List;

import com.revature.model.ReimbursementType;
import com.revature.model.ReimbursementsStatus;

public interface ValidateReimbursement {

	static double validateAmount(String parameter) {
		// TODO Auto-generated method stub
		return 1f;
	}
		
		static ReimbursementType validateType(List<ReimbursementType> typeList, String parameter) {
		// TODO Auto-generated method stub
		return null;
		
		
	}

	static ReimbursementsStatus setReimbursementsStatus(List<ReimbursementsStatus> statusList, String string, String statusSelected) {
		// TODO Auto-generated method stub
		System.out.println("Reached reimb status");
		int statusId= 1;
		System.out.println(new ReimbursementsStatus(statusId, statusSelected));
		return new ReimbursementsStatus(statusId, statusSelected);
		
	}

	

	
}
