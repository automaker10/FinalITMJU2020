package com.project.stlp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@PrimaryKeyJoinColumn(name = "username")
public class Person extends Login {
	@Column(name = "nameperson", length = 40, nullable = false)
	private String nameperson;
	@Column(name = "emailperson", length = 40, nullable = false)
	private String emailperson;
	@Column(name = "telperson", length = 15, nullable = false)
	private String telperson;

	public String getNameperson() {
		return nameperson;
	}

	public void setNameperson(String nameperson) {
		this.nameperson = nameperson.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C");
	}

	public String getEmailperson() {
		return emailperson;
	}

	public void setEmailperson(String emailperson) {
		this.emailperson = emailperson;
	}

	public String getTelperson() {
		return telperson;
	}

	public void setTelperson(String telperson) {
		this.telperson = telperson;
	}
}
