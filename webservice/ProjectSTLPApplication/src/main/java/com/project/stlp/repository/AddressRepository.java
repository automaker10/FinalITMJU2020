package com.project.stlp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.stlp.entity.Address;


public interface AddressRepository extends CrudRepository<Address, Long> {
	@Query("From Address") // select
	List<Address> getListAddress();

	@Query("Select a from Address a where a.stateleeeperson.username = ?1") // select
	List<Address> getAddressByUsername(String username);

	@Query("From Address a where a.detailaddress = ?1") // select
	Address getAddressByDetail(String detail);
}
