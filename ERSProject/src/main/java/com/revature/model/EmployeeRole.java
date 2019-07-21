package com.revature.model;

import java.io.Serializable;

public class EmployeeRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6909276859483041195L;

	
	private int id;
	private String type;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		EmployeeRole other = (EmployeeRole) obj;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}





	@Override
	public String toString() {
		return "EmployeeRole [id=" + id + ", type=" + type + "]";
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
	}





	public EmployeeRole(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	
}
