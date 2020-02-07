package com.project.stlp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.stlp.entity.IDCardType;


public interface IDCardTypeRepository extends CrudRepository<IDCardType, Long> {

	@Query("Select i from IDCardType i where i.idcardno = ?1") // select
	IDCardType getIDCardTypeByIDCard_NO(String idcardNO);

	@Query("From IDCardType") // select
	List<IDCardType> getListIdCardType();

	@Query("Select i from IDCardType i where i.idcardno = ?1")
	IDCardType checkDup(String idcardno);

	@Modifying
	@Transactional
	@Query(value = "delete from IDCardType i where i.idcardno = ?1")
	void deleteidcardTypeByIdcardno(String idcardno);
}
