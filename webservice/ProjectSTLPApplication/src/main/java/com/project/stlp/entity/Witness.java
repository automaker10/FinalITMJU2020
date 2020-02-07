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
@Table(name = "witness")
public class Witness {
	@Id
	@Column(name = "witnessid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int witnessid;
	@Column(name = "namewitness", length = 50, nullable = false)
	private String namewitness;
	@Column(name = "relationship", length = 20, nullable = false)
	private String relationship;
	@Column(name = "statusbealive", columnDefinition = "TINYINT", nullable = false)
	private int statusbealive;
	@Column(name = "addresswitness", length = 255, nullable = false)
	private String addresswitness;

	public int getWitnessid() {
		return witnessid;
	}

	public void setWitnessid(int witnessid) {
		this.witnessid = witnessid;
	}

	public String getNamewitness() {
		return namewitness;
	}

	public void setNamewitness(String namewitness) {
		this.namewitness = namewitness;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public int getStatusbealive() {
		return statusbealive;
	}

	public void setStatusbealive(int statusbealive) {
		this.statusbealive = statusbealive;
	}

	public String getAddresswitness() {
		return addresswitness;
	}

	public void setAddresswitness(String addresswitness) {
		this.addresswitness = addresswitness;
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
