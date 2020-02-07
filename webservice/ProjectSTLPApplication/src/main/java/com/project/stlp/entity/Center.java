package com.project.stlp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "center")
public class Center {
	@Id
	@Column(name = "telcenter", length = 15)
	private String telcenter;
	@Column(name = "namecenter", length = 255, nullable = false)
	private String namecenter;
	@Column(name = "emailcenter", length = 40, nullable = false)
	private String emailcenter;
	@Column(name = "addresscenter", length = 255, nullable = false)
	private String addresscenter;

	public String getTelcenter() {
		return telcenter;
	}

	public void setTelcenter(String telcenter) {
		this.telcenter = telcenter;
	}

	public String getNamecenter() {
		return namecenter;
	}

	public void setNamecenter(String namecenter) {
		this.namecenter = namecenter.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C");
	}

	public String getEmailcenter() {
		return emailcenter;
	}

	public void setEmailcenter(String emailcenter) {
		this.emailcenter = emailcenter;
	}

	public String getAddresscenter() {
		return addresscenter;
	}

	public void setAddresscenter(String addresscenter) {
		this.addresscenter = addresscenter.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C").replaceAll("\n","%0A");
	}

	@OneToMany(mappedBy = "center",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Staff> staffList;

	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

	@OneToMany(mappedBy = "center")
	@JsonIgnore
	private List<RequestForHelp> requestForHelpsList;

	public List<RequestForHelp> getRequestForHelpsList() {
		return requestForHelpsList;
	}

	public void setRequestForHelpsList(List<RequestForHelp> requestForHelpsList) {
		this.requestForHelpsList = requestForHelpsList;
	}
}
