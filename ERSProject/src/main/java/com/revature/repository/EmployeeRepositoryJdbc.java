package com.revature.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Date;


import org.apache.log4j.Logger;

import com.revature.model.Employee;
import com.revature.model.EmployeeRole;
import com.revature.model.EmployeeToken;
import com.revature.util.ConnectionUtil;

public class EmployeeRepositoryJdbc implements EmployeeRepository{

	private static Logger logger = Logger.getLogger(EmployeeRepositoryJdbc.class);

	/*Singleton transformation of JDBC implementation object */
	private static EmployeeRepositoryJdbc employeeDaoJdbc;

	EmployeeRepositoryJdbc() {

	}

	public static EmployeeRepository getInstance() {
		if(employeeDaoJdbc == null) {
			employeeDaoJdbc = new EmployeeRepositoryJdbc();
		}

		return employeeDaoJdbc;
	}

	//Creating new user account 
	public boolean insert(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection())
		{
			int statementIndex = 0;
			String command = "INSERT INTO USER_T VALUES(?,?,?,?,?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(command);

			statement.setInt(++statementIndex, employee.getId());
			statement.setString(++statementIndex, employee.getFirstName().toUpperCase());
			statement.setString(++statementIndex, employee.getLastName().toUpperCase());
			statement.setString(++statementIndex, employee.getUsername().toLowerCase());
			statement.setString(++statementIndex, employee.getPassword());
			statement.setString(++statementIndex, employee.getEmail());
			statement.setInt(++statementIndex, employee.getUrId());
			statement.setString(++statementIndex, employee.getRole());


			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			logger.warn("Exception creating new Account", e);
		}
		return false;
	}

	/* Insert a employee using the stored procedure created */
	@Override
	public boolean insertProcedure(Employee employee) {
		try(Connection connection = ConnectionUtil.getConnection())
		{
			int statementIndex = 0;
			String command = "{CALL INSERT_USER_T(?,?,?,?,?,?,?,?)}";
			CallableStatement statement = connection.prepareCall(command);


			statement.setInt(++statementIndex, employee.getId());
			statement.setString(++statementIndex, employee.getFirstName().toUpperCase());
			statement.setString(++statementIndex, employee.getLastName().toUpperCase());
			statement.setString(++statementIndex, employee.getUsername().toLowerCase());
			statement.setString(++statementIndex, employee.getPassword());
			statement.setString(++statementIndex, employee.getEmail());
			statement.setInt(++statementIndex, employee.getUrId());
			statement.setString(++statementIndex, employee.getRole());

			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			logger.warn("Exception creating a new employee with stored procedure", e);
		}
		return false;
	}


	public Employee login(Employee employee) {
		logger.trace("Finding User Information");

		try(Connection connection = ConnectionUtil.getConnection()) {

			int statementIndex = 0;
			String command = "SELECT * FROM USER_T WHERE U_USERNAME = ? AND U_PASSWORD =? AND U_ROLE=?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, employee.getUsername());
			statement.setString(++statementIndex, employee.getPassword());
			statement.setString(++statementIndex, employee.getRole());
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				logger.trace("Found account");

				return new Employee(
						result.getInt("U_ID"),
						result.getString("U_FIRSTNAME"),
						result.getString("U_LASTNAME"),
						result.getString("U_USERNAME"),
						result.getString("U_PASSWORD"),
						result.getString("U_EMAIL"),
						result.getInt("UR_ID"),
						result.getString("U_ROLE"));

			}
		} catch (SQLException e) {
			logger.error("Exception finding a employee", e);
		}
		return new Employee();
	}


	/* Select Employee based on his username */
	public Employee select(Employee employee) {
		logger.trace("Finding User Information");

		try(Connection connection = ConnectionUtil.getConnection()) {

			int statementIndex = 0;
			String command = "SELECT * FROM USER_T WHERE U_USERNAME = ? AND U_PASSWORD =? AND U_ROLE=?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, employee.getUsername());
			statement.setString(++statementIndex, employee.getPassword());
			statement.setString(++statementIndex, employee.getRole());
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				logger.trace("Found account");

				return new Employee(
						result.getInt("U_ID"),
						result.getString("U_FIRSTNAME"),
						result.getString("U_LASTNAME"),
						result.getString("U_USERNAME"),
						result.getString("U_PASSWORD"),
						result.getString("U_EMAIL"),
						result.getInt("UR_ID"),
						result.getString("U_ROLE"));

			}
		} catch (SQLException e) {
			logger.error("Exception finding a employee", e);
		}
		return new Employee();
	}

	/* Select all employees */
	public List<Employee> selectAll() {
		try(Connection connection = ConnectionUtil.getConnection()){
			String command = "SELECT * FROM USER_T WHERE U_ROLE = 'EMPLOYEE'";
			PreparedStatement statement = connection.prepareStatement(command);
			ResultSet result = statement.executeQuery();

			List<Employee> employeeList = new ArrayList<Employee>();
			while(result.next()) {
				employeeList.add(new Employee(
						result.getInt("U_ID"),
						result.getString("U_FIRSTNAME"),
						result.getString("U_LASTNAME"),
						result.getString("U_USERNAME"),
						result.getString("U_PASSWORD"),
						result.getString("U_EMAIL"),
						result.getInt("UR_ID"),
						result.getString("U_ROLE")
						));

			}

			return employeeList;
		} catch (SQLException e) {
			logger.warn("Exception selecting all employees", e);
		} 
		return new ArrayList<>();
	}

	public boolean update(Employee employee) {

		try(Connection connection = ConnectionUtil.getConnection())
		{
			int parameterIndex = 0;
			String 	query = "UPDATE USER_T SET U_ID =?, U_FIRSTNAME=?,U_LASTNAME=?,U_EMAIL=?"
					+"U_USERNAME=?,U_PASSWORD=?,U_ROLE=? WHERE U_USERNAME = U_USERNAME";
			

			PreparedStatement stmt = connection.prepareStatement(query);

			stmt.setInt(++parameterIndex, employee.getId());
			stmt.setString(++parameterIndex,employee.getFirstName());
			stmt.setString(++parameterIndex,employee.getLastName());
			stmt.setString(++parameterIndex,employee.getEmail());
			stmt.setString(++parameterIndex,employee.getUsername());
			stmt.setString(++parameterIndex,employee.getPassword());
			stmt.setString(++parameterIndex,employee.getRole());
											

			if(stmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			logger.warn("Exception updating/creating employee account", e);
		}
		return false;
	}

	
	
	public Employee select(int employeeId) {
		return null;
	
				
	}


	public Employee select(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPasswordHash(Employee employee) {
		// TODO Auto-generated method stub
		try(Connection connection = ConnectionUtil.getConnection()){
			int statementIndex = 0;
			String command = "SELECT GET_EMPLOYEE_HASH(?,?) AS HASH FROM DUAL";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setString(++statementIndex, employee.getUsername());
			statement.setString(++statementIndex, employee.getPassword());
			ResultSet result = statement.executeQuery();

			if(result.next()) {
				return result.getString("HASH");
			}
		} catch (SQLException e) {
			logger.warn("Exception getting employee hash", e);
		} 
		return new String();
	}



	public boolean insertEmployeeToken(EmployeeToken employeeToken) {
		// TODO Auto-generated method stub
		try (Connection connection = ConnectionUtil.getConnection())
		{
			int statementIndex = 0;
			String command = "INSERT INTO EMPLOYEETOKEN VALUES(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex, employeeToken.getId());
			statement.setString(++statementIndex, employeeToken.getToken().toUpperCase());
			//	statement.setDate(++statementIndex,employeeToken.getCreationDate());
			//	statement.setInt(++statementIndex,employeeToken.getRequester());

			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			logger.warn("Exception creating a new employeeToken", e);
		}
		return false;
	}

	public boolean deleteEmployeeToken(EmployeeToken employeeToken) {
		// TODO Auto-generated method stub
		try(Connection connection = ConnectionUtil.getConnection())
		{
			int statementIndex = 0;
			String command = "DELETE FROM EMPLOYEETOKEN WHERE U_ID_=?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex,employeeToken.getId());
			ResultSet result = statement.executeQuery();
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			logger.warn("Exception deleting new employeeToken", e);
		}
		return false;

	}
	@Override
	public EmployeeToken selectEmployeeToken(EmployeeToken employeeToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee employeeById(Employee employee) {
		
		try(Connection connection = ConnectionUtil.getConnection())
		{
			int statementIndex = 0;
			String command = "SELECT * FROM USER_T WHERE U_ROLE = 'EMPLOYEE' AND U_ID=?";
			PreparedStatement statement = connection.prepareStatement(command);
			statement.setInt(++statementIndex,employee.getId());
			
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				logger.trace("found account");
			    return new Employee(
						result.getInt("U_ID"),
						result.getString("U_FIRSTNAME"),
						result.getString("U_LASTNAME"),
						result.getString("U_USERNAME"),
						result.getString("U_PASSWORD"),
						result.getString("U_EMAIL"),
						result.getInt("UR_ID"),
						result.getString("U_ROLE")
						);
			    }
		}

			catch (SQLException e) {
				logger.warn("Exception deleting new employeeToken", e);
			}
			return new Employee();

		}
			
	

			

	public static void main(String[] args) {
		EmployeeRepositoryJdbc employee = new EmployeeRepositoryJdbc();

		//	logger.info(employee.select(new Employee("RGARNER","123456","EMPLOYEE")));

		//logger.info(employee.select(new Employee(001,"RACHEL","GARNER","RGARNER","123456",
		//		"RGARNER@GMAIL.COM",1,"EMPLOYEE")));

		//logger.info(employee.insert(new Employee(006,"Radhika","Guniganti","Rguniganti","123456",
		//	"rguniganti@yopmail.com",1,"EMPLOYEE")));




		Employee check = new Employee();
		check.setUsername("RGARNER");
		check.setPassword("123456");
		check.setRole("EMPLOYEE");

		System.out.println(employee.select(check));								
	}

	@Override
	public void employeeById(int i) {
		// TODO Auto-generated method stub
		
	}

	
	



}




