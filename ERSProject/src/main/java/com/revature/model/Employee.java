package com.revature.model;

import java.io.Serializable;

public class Employee implements Serializable, Comparable<Employee>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4123076219236755388L;
	
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private int urId;
	private String role;
	
	

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", urId=" + urId + ", role=" + role + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + urId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (urId != other.urId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public int getUrId() {
		return urId;
	}




	public void setUrId(int urId) {
		this.urId = urId;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	public Employee(int id, String firstName, String lastName, String username, String password, String email, int urId,
			String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.urId = urId;
		this.role = role;
	}



	public Employee(int i, Object object, Object object2, Object object3, String parameter, String parameter2,
			String parameter3) {
		// TODO Auto-generated constructor stub
	}

	public Employee(Object object, Object object2, Object object3, String parameter, String parameter2,
			String parameter3) {
		// TODO Auto-generated constructor stub
	}

	public Employee(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Employee arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
	
	