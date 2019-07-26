package com.revature.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.ReimbursementsStatus;
import com.revature.model.ReimbursementType;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.repository.ReimbursementRepositoryJdbc;

public class ReimbursementController implements ReimbursementControllerInterface {

private static ReimbursementControllerInterface reimbcontroller = new ReimbursementController();
	
	private ReimbursementController() {}
	
	public static ReimbursementControllerInterface getInstance() {
		return reimbcontroller;
		
	}
	  
	
	@Override
	public void insertReimbursement(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		System.out.println("ReimbContoller: insertReimb(): Got amount: " + req.getParameter("amount"));
		System.out.println("ReimbContoller: insertReimb(): Got descr: " + req.getParameter("description"));
		System.out.println("ReimbContoller: insertReimb(): Got type: " + req.getParameter("type"));
		try{
			HttpSession session = req.getSession();
			
			@SuppressWarnings("unchecked")
			List<ReimbursementType> typeList = (List<ReimbursementType>)session.getAttribute("types");
			@SuppressWarnings("unchecked")
			List<ReimbursementsStatus> statusList = (List<ReimbursementsStatus>) session.getAttribute("status");
					
			double amount = ValidateReimbursement.validateAmount(req.getParameter("amount"));
			System.out.println("ReimbContoller: insertReimb(): Validated amount: " + amount);
			ReimbursementType type = ValidateReimbursement.validateType(typeList, req.getParameter("type"));
			System.out.println("ReimbContoller: insertReimb(): Validated Type: "+ type);
		//	ReimbursementsStatus status = Validation.setReimbursementsStatus(statusList, "Pending");
		//	System.out.println("ReimbContoller: insertReimb(): Validated Status: " + status);
			Employee employee =(Employee) session.getAttribute("employee");
			String description = req.getParameter("description");
						
		//	Reimbursement reimb = ReimbursementRepositoryJdbc.insert(employee, amount, type, status, description);
			
			//getReimbs(req, resp);
			
			@SuppressWarnings("unchecked")
			List<Reimbursement> list = (List<Reimbursement>) session.getAttribute("reimbs");
			System.out.println("ReimbContoller: insertReimb(): list of reimbursements:" + list);
		//	list.add(reimb);
		//	System.out.println("ReimbContoller: insertReimb(): Added reimb: " + reimb);
			session.setAttribute("reimbs", list);
			
			req.getRequestDispatcher("EmployeeHomePage.html").forward(req, resp);
		}catch(Exception e){
			e.printStackTrace();
			try {
				String message = "Invalid input.";
				req.setAttribute("errorMessage", message);
				req.getRequestDispatcher("EmployeeHomePage.html").forward(req, resp);
				System.out.println("ReimbContoller: insertReimb(): Second forward.");
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
		
				
	

	@Override
	public void updateReimbursement(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	

}
