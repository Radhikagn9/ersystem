package com.revature.model;
import java.io.Serializable;
import java.time.LocalDateTime;

public class EmployeeToken implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3581354891631125205L;

	private int id;
	private String token;
	private LocalDateTime creationDate;
	private Employee requester;
	public EmployeeToken(int id, String token, LocalDateTime creationDate, Employee requester) {
		super();
		this.id = id;
		this.token = token;
		this.creationDate = creationDate;
		this.requester = requester;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public Employee getRequester() {
		return requester;
	}
	@Override
	public String toString() {
		return "EmployeeToken [id=" + id + ", token=" + token + ", creationDate=" + creationDate + ", requester="
				+ requester + "]";
	}
	public void setRequester(Employee requester) {
		this.requester = requester;
	}
	
	
	
}