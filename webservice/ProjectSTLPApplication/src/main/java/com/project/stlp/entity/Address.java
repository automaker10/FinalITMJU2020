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
@Table(name = "address")
public class Address {

	@Id
	@Column(name = "addressid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressid;
	@Column(name = "detailaddress", length = 255, nullable = false)
	private String detailaddress;
	@Column(name = "fromyears", length = 5)
	private String fromyears;
	@Column(name = "toyears", length = 5)
	private String toyears;
	@Column(name = "homestatus", nullable = false)
	private int homestatus;
	@Column(name = "statusaddress", nullable = false)
	private int statusaddress;

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getDetailaddress() {
		return detailaddress;
	}

	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}

	public String getFromyears() {
		return fromyears;
	}

	public void setFromyears(String fromyears) {
		this.fromyears = fromyears;
	}

	public String getToyears() {
		return toyears;
	}

	public void setToyears(String toyears) {
		this.toyears = toyears;
	}

	public int getHomestatus() {
		return homestatus;
	}

	public void setHomestatus(int homestatus) {
		this.homestatus = homestatus;
	}

	public int getStatusaddress() {
		return statusaddress;
	}

	public void setStatusaddress(int statusaddress) {
		this.statusaddress = statusaddress;
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
