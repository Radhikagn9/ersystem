package com.revature.model;
import java.io.Serializable;

public class ReimbursementsStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7908959256225754143L;
	
	private int id;
	private String status;
	
	
	@Override
	public String toString() {
		return "ReimbursementsStatus [id=" + id + ", status=" + status + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ReimbursementsStatus other = (ReimbursementsStatus) obj;
		if (id != other.id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public ReimbursementsStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	

}
