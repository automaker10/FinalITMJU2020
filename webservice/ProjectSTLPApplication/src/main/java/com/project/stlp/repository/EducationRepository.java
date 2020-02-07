package com.project.stlp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.stlp.entity.Education;


public interface EducationRepository extends CrudRepository<Education, Long> {
	@Query("From Education") // select
	List<Education> getListEducation();

	@Query("Select e from Education e where e.stateleeeperson.username = ?1") // select
	List<Education> getEducationByUsername(String username);

	@Query("From Education e where e.educationid = ?1") // select
	Education getEducationById(int educationID);

	@Query("From Education e where e.educationdetails = ?1") // select
	Education getEducationByDetail(String detail);
}
