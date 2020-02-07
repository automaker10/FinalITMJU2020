package com.project.stlp.entity;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "idcardtype")
public class IDCardType {
	@Id
	@Column(name = "idcardno", length = 13)
	private String idcardno;
	@Column(name = "idcardcall", length = 255, nullable = false)
	private String idcardcall;
	@Column(name = "idcardmean", length = 500, nullable = false)
	private String idcardmean;
	@Column(name = "idcardjob", length = 500, nullable = false)
	private String idcardjob;
	@Column(name = "benefitsfromgovern", length = 1000, nullable = false)
	private String benefitsfromgovern;

	public String getIdcardno() {
		return idcardno;
	}

	public void setIdcardno(String idcardno) {
		this.idcardno = idcardno;
	}

	public String getIdcardcall() {
		
		return idcardcall;
	}

	public void setIdcardcall(String idcardcall) {

		this.idcardcall = idcardcall.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C").replaceAll(System.lineSeparator(),"%0A").replaceAll("\\)","%29").replaceAll("\\(","%28");
	}

	public String getIdcardmean() {
		
		return idcardmean;
	}

	public void setIdcardmean(String idcardmean) {

		this.idcardmean = idcardmean.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C").replaceAll(System.lineSeparator(),"%0A").replaceAll("\\)","%29").replaceAll("\\(","%28");

	}

	public String getIdcardjob() {
		
		return idcardjob;
	}

	public void setIdcardjob(String idcardjob) {

		this.idcardjob = idcardjob.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C").replaceAll(System.lineSeparator(),"%0A").replaceAll("\\)","%29").replaceAll("\\(","%28");

	}

	public String getBenefitsfromgovern() {
		
		return benefitsfromgovern;
	}

	public void setBenefitsfromgovern(String benefitsfromgovern) {
		

		this.benefitsfromgovern = benefitsfromgovern.replaceAll(" ", "+").replaceAll("/", "%2F").replaceAll(",", "%2C").replaceAll(System.lineSeparator(),"%0A").replaceAll("\\)","%29").replaceAll("\\(","%28");

	}

	@OneToMany(mappedBy = "idcardtype")
	@JsonIgnore
	private List<StatelessPerson> statelesspersonList;

	public List<StatelessPerson> getStatelesspersonList() {
		return statelesspersonList;
	}

	public void setStatelesspersonList(List<StatelessPerson> statelesspersonList) {
		this.statelesspersonList = statelesspersonList;
	}
}
