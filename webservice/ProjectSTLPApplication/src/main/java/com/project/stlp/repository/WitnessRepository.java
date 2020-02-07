package com.project.stlp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.stlp.entity.Witness;


public interface WitnessRepository extends CrudRepository<Witness, Long> {
	@Query("From Witness") // select
	List<Witness> getListWitness();

	@Query("Select w from Witness w where w.stateleeeperson.username = ?1") // select
	List<Witness> getWitnessByUsername(String username);

	@Query("From Witness w where w.witnessid = ?1") // select
	Witness getWitnessById(int witness);

	@Query("From Witness w where w.namewitness = ?1") // select
	Witness getWitnessByName(String namewitness);
}
