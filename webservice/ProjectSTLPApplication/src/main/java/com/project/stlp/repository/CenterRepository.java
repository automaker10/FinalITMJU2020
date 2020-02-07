package com.project.stlp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.stlp.entity.Center;


@Repository
public interface CenterRepository extends CrudRepository<Center, Long> {

	@Query("From Center c") // select
	List<Center> getListCenter();

	@Query("From Center cen where cen.telcenter = ?1") // select
	Center getCenterByTelCenter(String telcenter);

	@Modifying
	@Transactional
	@Query(value = "delete from Center c where c.telcenter = ?1")
	void deleteCenterByTel(String telcenter);
	

	@Query("Select c from Center c where c.telcenter = ?1")
	Center checkDup(String telcenter);

}
