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
@Table(name = "parent")
public class Parent {
	@Id
	@Column(name = "parentid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int parentid;
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	@Column(name = "statusbealive", columnDefinition = "TINYINT", nullable = false)
	private int statusbealive;
	@Column(name = "birthday",length = 20)
	private String birthday;
	@Column(name = "idcard", length = 14, nullable = false)
	private String idcard;
	@Column(name = "ethnic", length = 50, nullable = false)
	private String ethnic;
	@Column(name = "nationality", length = 50, nullable = false)
	private String nationality;
	@Column(name = "datecomethai",length = 20)
	private String datecomethai;
	@Column(name = "address", length = 255, nullable = false)
	private String address;
	@Column(name = "statusparent", nullable = false)
	private int statusparent;

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public int getStatusbealive() {
		return statusbealive;
	}

	public void setStatusbealive(int statusbealive) {
		this.statusbealive = statusbealive;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getEthnic() {
		return ethnic;
	}

	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getDatecomethai() {
		return datecomethai;
	}

	public void setDatecomethai(String datecomethai) {
		this.datecomethai = datecomethai;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatusparent() {
		return statusparent;
	}

	public void setStatusparent(int statusparent) {
		this.statusparent = statusparent;
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
