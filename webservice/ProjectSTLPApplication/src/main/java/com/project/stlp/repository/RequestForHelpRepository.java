package com.project.stlp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.stlp.entity.RequestForHelp;


public interface RequestForHelpRepository extends CrudRepository<RequestForHelp, Long> {

	@Query("From RequestForHelp r where r.statelessperon.username = ?1") // select
	RequestForHelp getRequestByUsername(String username);

	@Query("From RequestForHelp r where r.requestid = ?1") // select
	RequestForHelp getRequestByIdRequest(int requestid);

	@Query("Select r from RequestForHelp r where r.center.telcenter = ?1") // select
	List<RequestForHelp> getRequestByTelCenter(String telcenter);

	@Query("From RequestForHelp") // select
	List<RequestForHelp> getListRequestForHelp();

	@Query("Select r from RequestForHelp r where r.statelessperon.username = ?1") // select
	RequestForHelp getDetailrequestByUsername(String username);

	@Query("From RequestForHelp r where r.statelessperon.username = ?1") // select
	RequestForHelp doApproveRequestForHelp(String username);

}
