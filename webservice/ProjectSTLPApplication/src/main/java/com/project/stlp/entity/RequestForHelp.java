package com.project.stlp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "requestforhelp")
public class RequestForHelp {
	@Id
	@Column(name = "requestid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestid;
	@Column(name = "cerbirth", nullable = false)
	private int cerbirth;
	@Column(name = "tr1", nullable = false)
	private int tr1;
	@Column(name = "tr2", nullable = false)
	private int tr2;
	@Column(name = "tr3", nullable = false)
	private int tr3;
	@Column(name = "tr0310", nullable = false)
	private int tr0310;
	@Column(name = "tr1front", nullable = false)
	private int tr1front;
	@Column(name = "tr11part1", nullable = false)
	private int tr11part1;
	@Column(name = "bcerbirth", nullable = false)
	private int bcerbirth;
	@Column(name = "bcerplacebirth", nullable = false)
	private int bcerplacebirth;
	@Column(name = "cerregister", nullable = false)
	private int cerregister;
	@Column(name = "tr14", nullable = false)
	private int tr14;
	@Column(name = "tr13", nullable = false)
	private int tr13;
	@Column(name = "fmperson", nullable = false)
	private int fmperson;
	@Column(name = "hfmpersonno2", nullable = false)
	private int hfmpersonno2;
	@Column(name = "trchk", nullable = false)
	private int trchk;
	@Column(name = "tr38g", nullable = false)
	private int tr38g;
	@Column(name = "tr381", nullable = false)
	private int tr381;
	@Column(name = "ceridcard", nullable = false)
	private int ceridcard;
	@Column(name = "thaiidcard", nullable = false)
	private int thaiidcard;
	@Column(name = "notthaiidcard", nullable = false)
	private int notthaiidcard;
	@Column(name = "statelessidcard", nullable = false)
	private int statelessidcard;
	@Column(name = "residencycer", nullable = false)
	private int residencycer;
	@Column(name = "refugeeidcardfromwar", nullable = false)
	private int refugeeidcardfromwar;
	@Column(name = "statusrequest", nullable = false)
	private int statusrequest;

	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public int getCerbirth() {
		return cerbirth;
	}

	public void setCerbirth(int cerbirth) {
		this.cerbirth = cerbirth;
	}

	public int getTr1() {
		return tr1;
	}

	public void setTr1(int tr1) {
		this.tr1 = tr1;
	}

	public int getTr2() {
		return tr2;
	}

	public void setTr2(int tr2) {
		this.tr2 = tr2;
	}

	public int getTr3() {
		return tr3;
	}

	public void setTr3(int tr3) {
		this.tr3 = tr3;
	}

	public int getTr0310() {
		return tr0310;
	}

	public void setTr0310(int tr0310) {
		this.tr0310 = tr0310;
	}

	public int getTr1front() {
		return tr1front;
	}

	public void setTr1front(int tr1front) {
		this.tr1front = tr1front;
	}

	public int getTr11part1() {
		return tr11part1;
	}

	public void setTr11part1(int tr11part1) {
		this.tr11part1 = tr11part1;
	}

	public int getBcerbirth() {
		return bcerbirth;
	}

	public void setBcerbirth(int bcerbirth) {
		this.bcerbirth = bcerbirth;
	}

	public int getBcerplacebirth() {
		return bcerplacebirth;
	}

	public void setBcerplacebirth(int bcerplacebirth) {
		this.bcerplacebirth = bcerplacebirth;
	}

	public int getCerregister() {
		return cerregister;
	}

	public void setCerregister(int cerregister) {
		this.cerregister = cerregister;
	}

	public int getTr14() {
		return tr14;
	}

	public void setTr14(int tr14) {
		this.tr14 = tr14;
	}

	public int getTr13() {
		return tr13;
	}

	public void setTr13(int tr13) {
		this.tr13 = tr13;
	}

	public int getFmperson() {
		return fmperson;
	}

	public void setFmperson(int fmperson) {
		this.fmperson = fmperson;
	}

	public int getHfmpersonno2() {
		return hfmpersonno2;
	}

	public void setHfmpersonno2(int hfmpersonno2) {
		this.hfmpersonno2 = hfmpersonno2;
	}

	public int getTrchk() {
		return trchk;
	}

	public void setTrchk(int trchk) {
		this.trchk = trchk;
	}

	public int getTr38g() {
		return tr38g;
	}

	public void setTr38g(int tr38g) {
		this.tr38g = tr38g;
	}

	public int getTr381() {
		return tr381;
	}

	public void setTr381(int tr381) {
		this.tr381 = tr381;
	}

	public int getCeridcard() {
		return ceridcard;
	}

	public void setCeridcard(int ceridcard) {
		this.ceridcard = ceridcard;
	}

	public int getThaiidcard() {
		return thaiidcard;
	}

	public void setThaiidcard(int thaiidcard) {
		this.thaiidcard = thaiidcard;
	}

	public int getNotthaiidcard() {
		return notthaiidcard;
	}

	public void setNotthaiidcard(int notthaiidcard) {
		this.notthaiidcard = notthaiidcard;
	}

	public int getStatelessidcard() {
		return statelessidcard;
	}

	public void setStatelessidcard(int statelessidcard) {
		this.statelessidcard = statelessidcard;
	}

	public int getResidencycer() {
		return residencycer;
	}

	public void setResidencycer(int residencycer) {
		this.residencycer = residencycer;
	}

	public int getRefugeeidcardfromwar() {
		return refugeeidcardfromwar;
	}

	public void setRefugeeidcardfromwar(int refugeeidcardfromwar) {
		this.refugeeidcardfromwar = refugeeidcardfromwar;
	}

	public int getStatusrequest() {
		return statusrequest;
	}

	public void setStatusrequest(int statusrequest) {
		this.statusrequest = statusrequest;
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username", nullable = false, unique = true)
	private StatelessPerson statelessperon;
	public StatelessPerson getStatelessperon() {
		return statelessperon;
	}

	public void setStatelessperon(StatelessPerson statelessperon) {
		this.statelessperon = statelessperon;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "telcenter", nullable = false)
	private Center center;

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	@OneToMany(mappedBy = "requestforhelp")
	@JsonIgnore
	private List<MoreRequest> morerequestSList = new ArrayList<MoreRequest>();

	public List<MoreRequest> getMorerequestSList() {
		return morerequestSList;
	}

	public void setMorerequestSList(List<MoreRequest> morerequestSList) {
		this.morerequestSList = morerequestSList;
	}

	@OneToMany(mappedBy = "requestforhelp")
	@JsonIgnore
	private List<Assign> assigntList;

	public List<Assign> getAssigntList() {
		return assigntList;
	}

	public void setAssigntList(List<Assign> assigntList) {
		this.assigntList = assigntList;
	}

}
