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
@Table(name = "education")
public class Education {
	@Id
	@Column(name = "educationid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int educationid;
	@Column(name = "educationdetails", length = 255, nullable = false)
	private String educationdetails;

	public int getEducationid() {
		return educationid;
	}

	public void setEducationid(int educationid) {
		this.educationid = educationid;
	}

	public String getEducationdetails() {
		return educationdetails;
	}

	public void setEducationdetails(String educationdetails) {
		this.educationdetails = educationdetails;

	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username", nullable = false)
	private StatelessPerson stateleeeperson;

	public StatelessPerson getStateleeeperson() {
		return stateleeeperson;
	}

	public void setStateleeeperson(StatelessPerson stateleeeperson) {
		this.stateleeeperson = stateleeeperson;
	}

}
