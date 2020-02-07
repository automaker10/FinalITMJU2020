package com.project.stlp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.stlp.entity.MoreRequest;


public interface MoreRequestForHelpRepository extends CrudRepository<MoreRequest, Long> {
	
	@Query("Select m from MoreRequest m where m.requestforhelp.requestid = ?1") // select
	List<MoreRequest> getMoreRequestByRequestId(int requestid);
	
	@Query("Select m from MoreRequest m where m.requestforhelp.requestid = ?1 and statusmrequest = 1") // select
	List<MoreRequest> listMoreRequestByIDRequest(int requestid);
	
	@Query("Select m from MoreRequest m where m.morerequestid = ?1") // select
	MoreRequest getMoreRequestById(int morerequestid);
	
	@Modifying
	@Transactional
	@Query(value = "delete from MoreRequest m where m.morerequestid = ?1")
	void deleteMoreRequestByid(int id);
}
