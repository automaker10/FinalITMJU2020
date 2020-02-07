package com.project.stlp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.stlp.entity.Parent;


public interface ParentRepository extends CrudRepository<Parent, Long> {
	@Query("From Parent") // select
	List<Parent> getListParent();

	@Query("Select p from Parent p where p.stateleeeperson.username = ?1") // select
	List<Parent> getParentByUsername(String username);

	@Query("From Parent p where p.parentid = ?1") // select
	Parent getParentById(int parent_id);

	@Query("From Parent p where p.name = ?1") // select
	Parent getParentByName(String name);
}
