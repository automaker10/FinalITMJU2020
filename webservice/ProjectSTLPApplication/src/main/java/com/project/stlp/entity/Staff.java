package com.project.stlp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "staff")
@PrimaryKeyJoinColumn(name = "username")
public class Staff extends Person {
	@Column(name = "position", length = 50, nullable = false)
	private String position;
	@Column(name = "address", length = 255, nullable = false)
	private String address;
	@Column(name = "statusstaff", nullable = false)
	private int statusstaff;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C").replaceAll("\n","%0A");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C").replaceAll("\n","%0A");
	}

	@ManyToOne(fetch = FetchType.EAGER,optional = false,cascade = CascadeType.ALL)
	@JoinColumn(name = "telcenter", nullable = false)
	private Center center;

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	public int getStatusstaff() {
		return statusstaff;
	}

	public void setStatusstaff(int statusstaff) {
		this.statusstaff = statusstaff;
	}

	@OneToMany(mappedBy = "staff")
	@JsonIgnore
	private List<Assign> assignList;

	public List<Assign> getAssignList() {
		return assignList;
	}

	public void setAssignList(List<Assign> assignList) {
		this.assignList = assignList;
	}

}
