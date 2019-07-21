package com.revature.controller;

import java.util.List;

import com.revature.model.ReimbursementType;
import com.revature.model.ReimbursementsStatus;

public interface Validation {

	static double validateAmount(String parameter) {
		// TODO Auto-generated method stub
		return 0;
	}

	static ReimbursementType validateType(List<ReimbursementType> typeList, String parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	static ReimbursementsStatus setReimbursementsStatus(List<ReimbursementsStatus> statusList, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
