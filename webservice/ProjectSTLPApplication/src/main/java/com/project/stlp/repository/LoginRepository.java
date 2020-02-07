package com.project.stlp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.stlp.entity.Login;


public interface LoginRepository extends CrudRepository<Login, Long> {
	@Query("Select l from Login l where l.username = ?1 and l.password = ?2")
	Login login(String username, String password);

}
