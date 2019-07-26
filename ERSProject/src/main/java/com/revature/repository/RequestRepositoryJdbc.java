package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Request;
import com.revature.model.Status;
import com.revature.util.ConnectionUtil;

public class RequestRepositoryJdbc implements RequestRepository{

	private static Logger logger = Logger.getLogger(RequestRepositoryJdbc.class);

	private static RequestRepository requestRepository = null;

	private RequestRepositoryJdbc() {}

	public static RequestRepository getInstance2() {
		if(requestRepository == null) {
			requestRepository = new RequestRepositoryJdbc();
		}
		return requestRepository;
	}

	@Override
	public boolean insertRequest(Request request) {
		try(Connection connection = ConnectionUtil.getConnection())
		{
			int statementIndex = 0;
			String command = "INSERT INTO REQUEST VALUES(?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(command);

			statement.setLong(++statementIndex, request.getId());
			statement.setString(++statementIndex, request.getType());
			statement.setLong(++statementIndex, request.getAccountId());
			statement.setString(++statementIndex, request.getStatus());

			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			logger.warn("Exception creating new Account", e);
		}
		return false;
	}



	@Override
	public List<Request> viewRequest() {
		// TODO Auto-generated method stub 

		try(Connection connection = ConnectionUtil.getConnection())
		{
			String command = "SELECT * FROM REQUEST"; 
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();

			List<Request> RequestList = new ArrayList<>();
			while(result.next()) {
				RequestList.add(new Request(
						result.getLong("R_ID"),
						result.getString("R_TYPE"),
						result.getLong("A_ID"),
						new Status(result.getLong("S_ID"),result.getString("R_STATUS"))
						));

			}
			return RequestList;
		} catch(SQLException e) {
			logger.warn("Error on selecting on all the employees",e);
		}


		return new ArrayList<>();
	}

	@Override
	public Request viewRequestByEmployee(long r_id) {
		// TODO Auto-generated method stub

		try(Connection connection = ConnectionUtil.getConnection())
		{
			int statementIndex = 0;
			String command = "SELECT * FROM REQUEST WHERE R_ID = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setLong(++statementIndex,r_id);
			ResultSet result = statement.executeQuery();

			if(result.next()) {
				return new Request(
						result.getLong("R_ID"),
						result.getString("R_TYPE"),
						result.getLong("A_ID"),
						new Status(result.getLong("S_ID"), result.getString("R_STATUS"))
						);
			}


		} catch (SQLException e) {
			logger.warn("Error on selecting on the employees", e);
		}

		return null;
	}

	@Override
	public boolean updateRequest(Request request) {
		// TODO Auto-generated method stub
		try(Connection connection = ConnectionUtil.getConnection())
		{
			int statementIndex = 0;
			String command="UPDATE REQUEST SET R_STATUS=? WHERE R_ID=?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex,request.getStatus());
			statement.setLong(++statementIndex,request.getId());
			ResultSet result = statement.executeQuery();
			if(result.next()) {

			}

		} catch (SQLException e) {
			logger.warn("Error on selecting on the employees", e);
		}

		return false;
	}
	
	
	
	@Override
	public List<Request> lookAtRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Request lookAtRequestByEmployee(long rID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Request lookAtRequestByEmployee(Request request) {
		try(Connection connection = ConnectionUtil.getConnection())
		{
			int parameterIndex = 0;
			String sql = "SELECT * FROM REQUEST WHERE A_ID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(++parameterIndex,request.getAccountId());
			ResultSet result = statement.executeQuery();

			//List<Request> RequestList = new ArrayList<>();
			if(result.next()) {
				return new Request(
						result.getLong("R_ID"),
						result.getString("R_TYPE"),
						result.getString("R_STATUS"),
						result.getLong("A_ID"));
			}

		} catch (SQLException e) {
			logger.warn("Error on selecting on the employees", e);
		}
		return null; 
	}

	@Override
	public List<Request> lookAtPendingRequests() {
		
		try(Connection connection = ConnectionUtil.getConnection())
		{
			String command = "SELECT * FROM REQUEST WHERE R_STATUS = 'Pending'";
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();

			List<Request> RequestList = new ArrayList<>();
			while(result.next()) {
				RequestList.add(new Request(
						result.getLong("R_ID"),
						result.getString("R_TYPE"),
						result.getString("R_STATUS"),
						result.getLong("A_ID"))
						);
			}

			return RequestList;
		} catch (SQLException e) {
			logger.warn("Error on selecting on all the employees", e);
		} 
		return new ArrayList<>();
	}

	@Override
	public List<Request> lookAtResolvedRequests() {
		// TODO Auto-generated method stub
		
		try(Connection connection = ConnectionUtil.getConnection())
		{
			String command = "SELECT * FROM REQUEST WHERE R_STATUS = 'Accept' OR R_STATUS = 'Rejected'";
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();

			List<Request> RequestList = new ArrayList<>();
			while(result.next()) {
				RequestList.add(new Request(
						result.getLong("R_ID"),
						result.getString("R_TYPE"),
						result.getString("R_STATUS"),
						result.getLong("A_ID"))
						);
			}

			return RequestList;
		} catch (SQLException e) {
			logger.warn("Error on selecting on all the employees", e);
		} 
		return new ArrayList<>();
		
	}

	@Override
	public Request lookAtPendingRequestByID(Request request) {
		// TODO Auto-generated method stub
		try(Connection connection = ConnectionUtil.getConnection())
		{
			String command = "SELECT * FROM REQUEST WHERE R_STATUS = 'Request not taken' AND A_ID = ?";
			PreparedStatement statement = connection.prepareStatement(command);
			
			int parameterIndex = 0;
			
			statement.setLong(++parameterIndex,request.getAccountId());
			ResultSet result = statement.executeQuery();

			//List<Request> RequestList = new ArrayList<>();
			if(result.next()) {
				return new Request(
						result.getLong("R_ID"),
						result.getString("R_TYPE"),
						result.getString("R_STATUS"),
						result.getLong("A_ID"));
			}
		} catch (SQLException e) {
			logger.warn("Error on selecting on all the employees", e);
		} 
		return null;
	}

	@Override
	public Request lookAtResolvedRequestsByID(Request request) {
		// TODO Auto-generated method stub
		
		try(Connection connection = ConnectionUtil.getConnection())
		{
			String command = "SELECT * FROM REQUEST WHERE R_STATUS = 'Accept' OR R_STATUS = 'Rejected' AND A_ID = ?";
			PreparedStatement statement = connection.prepareStatement(command);

			int parameterIndex = 0;

			statement.setLong(++parameterIndex,request.getAccountId());
			ResultSet result = statement.executeQuery();

			//List<Request> RequestList = new ArrayList<>();
			if(result.next()) {
				return new Request(
						result.getLong("R_ID"),
						result.getString("R_TYPE"),
						result.getString("R_STATUS"),
						result.getLong("A_ID"));
			} 
		}
		catch (SQLException e) {
			logger.warn("Error on selecting on all the employees", e); 
		}
		
			
		return null;
	}
	public static void main(String[] args) {
		RequestRepositoryJdbc request = new RequestRepositoryJdbc();
		logger.info(request.viewRequest());
	}
}
		