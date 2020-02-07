package com.project.stlp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.stlp.entity.Assign;


public interface AssignRepository extends CrudRepository<Assign, Long> {
	@Query("Select a from Assign a where a.staff.username = ?1") // select
	List<Assign> getAssignByUsername(String username);
	
	@Query("Select a from Assign a where (a.staff.username = ?1 and statusassign = 2) or (a.staff.username = ?1 and statusassign = 3)") // select
	List<Assign> listSuggestionHistory(String username);

	@Query("Select a from Assign a where a.assignid = ?1") // select
	Assign getAssignByAssignid(int assignid);

	@Query("Select a from Assign a where a.requestforhelp.requestid = ?1 and statusassign = 2") // select
	List<Assign> getAssignByRequestId(int requestid);

	@Query("Select a from Assign a where a.requestforhelp.requestid = ?1 and statusassign = 3") // select
	List<Assign> getAssignByRequestIdAS3(int requestid);
	
	@Query("Select a from Assign a where a.requestforhelp.requestid = ?1 and statusassign = 3") // select
	Assign detailBestSuggestion(int requestid);

	@Query("Select a from Assign a where a.assignid = ?1") // select
	Assign getDetailAsssginByAssignid(int assignid);

	@Query("Select a from Assign a where a.requestforhelp.requestid = ?1 and statusassign = 3") // select
	Assign getAssignDetailByIdrequest(int requestid);
	
	@Modifying
	@Transactional
	@Query(value = "delete from Assign a where a.staff.username = ?1")
	void deleteAssignByUsername(String username);
}
