package com.project.stlp.entity;

import java.util.Date;
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
@Table(name = "statelessperson")
@PrimaryKeyJoinColumn(name = "username")
public class StatelessPerson extends Person {

	@Column(name = "gender", nullable = false)
	private int gender;
	@Column(name = "birthday", nullable = false)
	private Date birthday;
	@Column(name = "religion", length = 25, nullable = false)
	private String religion;
	@Column(name = "ethnic", length = 50, nullable = false)
	private String ethnic;
	@Column(name = "nationality", length = 50, nullable = false)
	private String nationality;
	@Column(name = "homeid", length = 25, nullable = false)
	private String homeid;
	@Column(name = "idcard", length = 14, nullable = false)
	private String idcard;
	@Column(name = "statusmarry", length = 1, nullable = false)
	private int statusmarry;
	@Column(name = "nameofspouse", length = 50)
	private String nameofspouse;
	@Column(name = "idcardofspouse", length = 14)
	private String idcardofspouse;
	@Column(name = "nationalityofspouse", length = 50)
	private String nationalityofspouse;
	@Column(name = "dateofmarry", length = 20)
	private String dateofmarry;
	@Column(name = "addressofspouse", length = 255)
	private String addressofspouse;
	@Column(name = "statusplaceofbirth", columnDefinition = "TINYINT", nullable = false)
	private int statusplaceofbirth;
	@Column(name = "statusthaiorabroadbirth", columnDefinition = "TINYINT", nullable = false)
	private int statusthaiorabroadbirth;
	@Column(name = "hospitalofbirth", length = 255)
	private String hospitalofbirth;
	@Column(name = "addressofvillagebirth", length = 255)
	private String addressofvillagebirth;
	@Column(name = "statuswitness", nullable = false)
	private int statuswitness;
	@Column(name = "countryofbirth", length = 50)
	private String countryofbirth;
	@Column(name = "districtcomethai", length = 20)
	private String districtcomethai;
	@Column(name = "datecomethai", length = 20)
	private String datecomethai;
	@Column(name = "modecomethai", length = 25)
	private String modecomethai;

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
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

	public String getHomeid() {
		return homeid;
	}

	public void setHomeid(String homeid) {
		this.homeid = homeid;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public int getStatusmarry() {
		return statusmarry;
	}

	public void setStatusmarry(int statusmarry) {
		this.statusmarry = statusmarry;
	}

	public String getNameofspouse() {
		return nameofspouse;
	}

	public void setNameofspouse(String nameofspouse) {
		this.nameofspouse = nameofspouse;
	}

	public String getIdcardofspouse() {
		return idcardofspouse;
	}

	public void setIdcardofspouse(String idcardofspouse) {
		this.idcardofspouse = idcardofspouse;
	}

	public String getNationalityofspouse() {
		return nationalityofspouse;
	}

	public void setNationalityofspouse(String nationalityofspouse) {
		this.nationalityofspouse = nationalityofspouse;
	}

	public String getDateofmarry() {
		return dateofmarry;
	}

	public void setDateofmarry(String dateofmarry) {
		this.dateofmarry = dateofmarry;
	}

	public String getAddressofspouse() {
		return addressofspouse;
	}

	public void setAddressofspouse(String addressofspouse) {

		this.addressofspouse = addressofspouse;
	}

	public int getStatusplaceofbirth() {
		return statusplaceofbirth;
	}

	public void setStatusplaceofbirth(int statusplaceofbirth) {
		this.statusplaceofbirth = statusplaceofbirth;
	}

	public int getStatusthaiorabroadbirth() {
		return statusthaiorabroadbirth;
	}

	public void setStatusthaiorabroadbirth(int statusthaiorabroadbirth) {
		this.statusthaiorabroadbirth = statusthaiorabroadbirth;
	}

	public String getHospitalofbirth() {
		return hospitalofbirth;
	}

	public void setHospitalofbirth(String hospitalofbirth) {
		this.hospitalofbirth = hospitalofbirth;
	}

	public String getAddressofvillagebirth() {
		return addressofvillagebirth;
	}

	public void setAddressofvillagebirth(String addressofvillagebirth) {
		this.addressofvillagebirth = addressofvillagebirth;

	}

	public int getStatuswitness() {
		return statuswitness;
	}

	public void setStatuswitness(int statuswitness) {
		this.statuswitness = statuswitness;
	}

	public String getCountryofbirth() {
		return countryofbirth;
	}

	public void setCountryofbirth(String countryofbirth) {
		this.countryofbirth = countryofbirth;
	}

	public String getDistrictcomethai() {
		return districtcomethai;
	}

	public void setDistrictcomethai(String districtcomethai) {
		this.districtcomethai = districtcomethai;
	}

	public String getDatecomethai() {
		return datecomethai;
	}

	public void setDatecomethai(String datecomethai) {
		this.datecomethai = datecomethai;
	}

	public String getModecomethai() {
		return modecomethai;
	}

	public void setModecomethai(String modecomethai) {
		this.modecomethai = modecomethai;
	}

	@ManyToOne(cascade = { CascadeType.ALL },fetch = FetchType.EAGER)
	@JoinColumn(name = "idcardno", nullable = false)
	private IDCardType idcardtype;

	public IDCardType getIdcardtype() {
		return idcardtype;
	}

	public void setIdcardtype(IDCardType idcardtype) {
		this.idcardtype = idcardtype;
	}

	@OneToMany(mappedBy = "stateleeeperson")
	@JsonIgnore
	private List<Address> addressList;

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	@OneToMany(mappedBy = "stateleeeperson")
	@JsonIgnore
	private List<Witness> witness;
	public List<Witness> getWitness() {
		return witness;
	}

	public void setWitness(List<Witness> witness) {
		this.witness = witness;
	}

	@OneToMany(mappedBy = "stateleeeperson")
	@JsonIgnore
	private List<Education> educationList;

	public List<Education> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<Education> educationList) {
		this.educationList = educationList;
	}

	@OneToMany(mappedBy = "stateleeeperson")
	@JsonIgnore
	private List<Parent> parentList;

	public List<Parent> getParentList() {
		return parentList;
	}

	public void setParentList(List<Parent> parentList) {
		this.parentList = parentList;
	}

}
