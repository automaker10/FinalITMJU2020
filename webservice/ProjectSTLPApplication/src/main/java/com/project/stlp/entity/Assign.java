package com.project.stlp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assign")
public class Assign {
	@Id
	@Column(name = "assignid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int assignid;
	@Column(name = "factperson", length = 1000, nullable = false)
	private String factperson;
	@Column(name = "factfathermother", length = 1000, nullable = false)
	private String factfathermother;
	@Column(name = "forlegalopinion", length = 1000, nullable = false)
	private String forlegalopinion;
	@Column(name = "personstatus", length = 1000, nullable = false)
	private String personstatus;
	@Column(name = "statusassign", nullable = false)
	private int statusassign;

	public int getAssignid() {
		return assignid;
	}

	public void setAssignid(int assignid) {
		this.assignid = assignid;
	}

	public String getFactperson() {
		return factperson;
	}

	public void setFactperson(String factperson) {
		this.factperson = factperson;
	}

	public String getFactfathermother() {
		return factfathermother;
	}

	public void setFactfathermother(String factfathermother) {
		this.factfathermother = factfathermother;
	}

	public String getForlegalopinion() {
		return forlegalopinion;
	}

	public void setForlegalopinion(String forlegalopinion) {
		this.forlegalopinion = forlegalopinion;
	}

	public String getPersonstatus() {
		return personstatus;
	}

	public void setPersonstatus(String personstatus) {
		this.personstatus = personstatus;
	}

	public int getStatusassign() {
		return statusassign;
	}

	public void setStatusassign(int statusassign) {
		this.statusassign = statusassign;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "requestid", nullable = false)
	private RequestForHelp requestforhelp = new RequestForHelp();

	public RequestForHelp getRequestforhelp() {
		return requestforhelp;
	}

	public void setRequestforhelp(RequestForHelp requestforhelp) {
		this.requestforhelp = requestforhelp;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username", nullable = false)
	private Staff staff = new Staff();

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}
