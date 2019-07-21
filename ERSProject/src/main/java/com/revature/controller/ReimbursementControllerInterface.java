package com.revature.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.model.Reimbursement;

public interface ReimbursementControllerInterface {
	
	public void insertReimbursement(HttpServletRequest request, HttpServletResponse response);
	public void updateReimbursement(HttpServletRequest request, HttpServletResponse response);

}
