package com.project.stlp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.stlp.entity.Staff;


public interface StaffRepository extends CrudRepository<Staff, Long> {

	@Query("Select s from Staff s where s.center.telcenter = ?1 and statusstaff = 2") // select
	List<Staff> getStaffByTelCenter(String telcenter);
	
	@Query("From Staff s") // select
	List<Staff> getListStaff();

	@Query("Select s from Staff s where s.center.telcenter = ?1 and statusstaff = 1") // select
	Staff getPresidenByTelCenter(String telcenter);

	@Query("Select s from Staff s where s.username = ?1") // select
	Staff getStaffByUsername(String username);

	@Query("Select s from Staff s where s.username = ?1")
	Staff checkDup(String username);

	@Modifying
	@Transactional
	@Query(value = "delete from Staff s where s.center.telcenter = ?1")
	void deletePresidentByTelcenter(String telcenter);
	
	@Modifying
	@Transactional
	@Query(value = "delete from Staff s where s.username = ?1")
	void deleteStaffByUsername(String username);

}
