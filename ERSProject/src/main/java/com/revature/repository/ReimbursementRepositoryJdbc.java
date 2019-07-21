package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Reimbursement;
import com.revature.model.Employee;
import com.revature.model.ReimbursementsStatus;
import com.revature.model.ReimbursementType;
import com.revature.util.ConnectionUtil;

public class ReimbursementRepositoryJdbc implements ReimbursementRepository{


	private static Logger logger = Logger.getLogger(ReimbursementRepositoryJdbc.class);

	public boolean insert(Reimbursement reimbursement) {
		try{
			Connection connection = ConnectionUtil.getConnection();
			
			String command = "INSERT INTO REIMBURSEMENT VALUES(NULL,?,?,?,?,?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(command);
			
			statement.setInt(1, reimbursement.getId());
			statement.setTimestamp(2, new Timestamp(new Date().getTime()));
			statement.setTimestamp(3, new Timestamp(new Date().getTime()));
			statement.setDouble(4, reimbursement.getAmount());
			statement.setString(5,reimbursement.getDescription());
			statement.setObject(6,null );
			statement.setInt(7, reimbursement.getRequester().getId());
			statement.setObject(8,null );
			statement.setInt(9, reimbursement.getStatus().getId());
			statement.setInt(10, reimbursement.getType().getId());
			
			statement.executeUpdate();
			 
			
		if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			logger.warn("Exception creating a new Reimbursement", e);
		}

		return false;
	}

	public boolean update(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		try{
			Connection connection = ConnectionUtil.getConnection();
			
		String sql = "UPDATE REIMBURSMENT"
				+ " SET RS_ID = ?, R_RESOLVED = ?, MANAGER_ID = ?"
				+ " WHERE R_ID = ?";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
	
	stmt.setInt(1, reimbursement.getStatus().getId());
	stmt.setTimestamp(2, new Timestamp(new Date().getTime()));
	stmt.setInt(3, reimbursement.getId());
	stmt.setInt(4, reimbursement.getId());
	stmt.executeUpdate();
	

	
	if(stmt.executeUpdate() > 0) {
			return true;
		}
	} catch (SQLException e) {
		logger.warn("Exception updating Reimbursement", e);
	}

	return false;
	}

	@Override
	public List<String> getTypes()  {
		// TODO Auto-generated method stub
		try{
			Connection connection = ConnectionUtil.getConnection();
		List<String> results = new ArrayList<>();
		String sql= "SELECT RT_TYPE"
					+ " FROM REIMBURSEMENT_TYPE";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();		
		while(rs.next()) {
			results.add(rs.getString("RT_TYPE"));
		}
		System.out.println(results);
		return results;
	}
		
		catch (SQLException e) {
			logger.warn("Exception creating a new Reimbursement", e);
		}
		List<String> results = null;
		return results;
		

	
	}
		
	public Reimbursement select(int reimbursementId) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public Set<Reimbursement> selectPending(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Reimbursement> selectFinalized(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Reimbursement> selectAllPending() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Reimbursement> selectAllFinalized() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<ReimbursementType> selectTypes() {
		// TODO Auto-generated method stub
		
	return null;
	}

	
	//Helper method
	// * @param rs
	// * @param results
	 //* @throws SQLException 
	// */
	private void mapRows(ResultSet rs, List<Reimbursement> results) throws SQLException {
		while(rs.next()) {
			int reimb_id = rs.getInt("R_ID");
			Float amount = rs.getFloat("R_AMOUNT");
			Date date_submitted = rs.getDate("R_REQUESTED");
			Date date_resolved = rs.getDate("R_RESOLVED");
			String description = rs.getString("R_DESCRIPTION");
			Employee requester = (Employee) rs.getObject("R_REQUESTER");
			Employee resolver = (Employee) rs.getObject("R_RESOLVER");
			ReimbursementsStatus status_id = (ReimbursementsStatus) rs.getObject("RS_ID");
			ReimbursementType type_id = (ReimbursementType) rs.getObject("RT_ID");
			Reimbursement obj = new Reimbursement(reimb_id, amount, date_submitted, date_resolved, 
									description, requester, resolver, status_id, type_id);
			results.add(obj);
			System.out.println(obj);
		}
		
		
	}// mapRows
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getConnection();
		ReimbursementRepositoryJdbc reimbursement = new ReimbursementRepositoryJdbc();
		EmployeeRepositoryJdbc user = new EmployeeRepositoryJdbc();

		
		user.employeeById(1);


	//	logger.info(reimbursement.insert(new Reimbursement(5,12-MAY-19 12.00.00.000000000 AM,null,"JAVACERT",null,1,null,1,2)));
		


		reimbursement.getTypes();

		connection.close();
		System.out.println("Finished");
	}

	
		
		
}
