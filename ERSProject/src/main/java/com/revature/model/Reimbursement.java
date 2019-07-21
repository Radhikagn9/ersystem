package com.revature.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Reimbursement  implements Serializable, Comparable<Reimbursement>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2784670697167623675L;
		
	private int id;
	private LocalDateTime requested;
	private double amount;
	private LocalDateTime date_resolved;
	private String description;
	private Object receipt;
	private Employee requester;
	private Employee approver;
	private ReimbursementsStatus status; 
	private ReimbursementType type;
	
	
		
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public LocalDateTime getRequested() {
		return requested;
	}



	public void setRequested(LocalDateTime requested) {
		this.requested = requested;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public LocalDateTime getDate_resolved() {
		return date_resolved;
	}



	public void setDate_resolved(LocalDateTime date_resolved) {
		this.date_resolved = date_resolved;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Object getReceipt() {
		return receipt;
	}



	public void setReceipt(Object receipt) {
		this.receipt = receipt;
	}



	public Employee getRequester() {
		return requester;
	}



	public void setRequester(Employee requester) {
		this.requester = requester;
	}



	public Employee getApprover() {
		return approver;
	}



	public void setApprover(Employee approver) {
		this.approver = approver;
	}



	public ReimbursementsStatus getStatus() {
		return status;
	}



	public void setStatus(ReimbursementsStatus status) {
		this.status = status;
	}



	public ReimbursementType getType() {
		return type;
	}



	public void setType(ReimbursementType type) {
		this.type = type;
	}



	public Reimbursement(int id, LocalDateTime requested, double amount, LocalDateTime date_resolved,
			String description, Object receipt, Employee requester, Employee approver, ReimbursementsStatus status,
			ReimbursementType type) {
		super();
		this.id = id;
		this.requested = requested;
		this.amount = amount;
		this.date_resolved = date_resolved;
		this.description = description;
		this.requester = requester;
		this.approver = approver;
		this.status = status;
		this.type = type;
	}



	public Reimbursement(int reimb_id, Float amount2, Date date_submitted, Date date_resolved2, String description2,
			Employee requester2, Employee resolver, ReimbursementsStatus status_id, ReimbursementType type_id) {
		// TODO Auto-generated constructor stub
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((approver == null) ? 0 : approver.hashCode());
		result = prime * result + ((date_resolved == null) ? 0 : date_resolved.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + ((requested == null) ? 0 : requested.hashCode());
		result = prime * result + ((requester == null) ? 0 : requester.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (approver == null) {
			if (other.approver != null)
				return false;
		} else if (!approver.equals(other.approver))
			return false;
		if (date_resolved == null) {
			if (other.date_resolved != null)
				return false;
		} else if (!date_resolved.equals(other.date_resolved))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		} else if (!receipt.equals(other.receipt))
			return false;
		if (requested == null) {
			if (other.requested != null)
				return false;
		} else if (!requested.equals(other.requested))
			return false;
		if (requester == null) {
			if (other.requester != null)
				return false;
		} else if (!requester.equals(other.requester))
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



	public int compareTo(Reimbursement o) {
		// TODO Auto-generated method stub
		return 0;
	}



	public int getR_ID() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}