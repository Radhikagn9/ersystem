package com.revature.model;

public class Request {
	
	private long id;
	private String type;
	private Status status;
	private long accountId;
	

	public Request() {}


	public Request(long id, String type, long accountId, Status status) {
		super();
		this.id = id;
		this.type = type;
		this.status = status;
		this.accountId = accountId;
	}


	public Request(String parameter) {
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public long getAccountId() {
		return accountId;
	}


	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Request other = (Request) obj;
		if (accountId != other.accountId)
			return false;
		if (id != other.id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
		return "Request [id=" + id + ", type=" + type + ", status=" + status + ", accountId=" + accountId + "]";
	}
	
}
