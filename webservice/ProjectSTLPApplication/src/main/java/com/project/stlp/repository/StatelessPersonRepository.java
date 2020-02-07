package com.project.stlp.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.stlp.entity.StatelessPerson;


public interface StatelessPersonRepository extends CrudRepository<StatelessPerson, Long> {
	@Query("Select s from StatelessPerson s where s.username = ?1")
	StatelessPerson checkDup(String username);
	
	@Query("Select s from StatelessPerson s where s.username = ?1") // select
	StatelessPerson getStatelessPersonByusername(String username);

}
