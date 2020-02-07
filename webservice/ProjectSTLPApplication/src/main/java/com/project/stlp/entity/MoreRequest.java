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
@Table(name = "morerequest")
public class MoreRequest {
	@Id
	@Column(name = "morerequestid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int morerequestid;
	@Column(name = "whatstoryforrequest", length = 500, nullable = false)
	private String whatstoryforrequest;
	@Column(name = "answer",length = 500 , nullable = false)
	private String answer;
	@Column(name = "statusmrequest", nullable = false)
	private int statusmrequest;

	public int getMorerequestid() {
		return morerequestid;
	}

	public void setMorerequestid(int morerequestid) {
		this.morerequestid = morerequestid;
	}

	public String getWhatstoryforrequest() {
		return whatstoryforrequest;
	}

	public void setWhatstoryforrequest(String whatstoryforrequest) {
		this.whatstoryforrequest = whatstoryforrequest;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getStatusmrequest() {
		return statusmrequest;
	}

	public void setStatusmrequest(int statusmrequest) {
		this.statusmrequest = statusmrequest;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "requestid", nullable = false)
	private RequestForHelp requestforhelp;

	public RequestForHelp getRequestforhelp() {
		return requestforhelp;
	}

	public void setRequestforhelp(RequestForHelp requestforhelp) {
		this.requestforhelp = requestforhelp;
	}

}
