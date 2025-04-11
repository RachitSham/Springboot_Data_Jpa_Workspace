package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer>{

	//@Query("SELECT p.pid, p.pname, p.paddrs, ph.regNo, ph.mobileNo, ph.provider, ph.numberType FROM Person p INNER JOIN p.contactDetails ph")
	//@Query("SELECT p.pid, p.pname, p.paddrs, ph.regNo, ph.mobileNo, ph.provider, ph.numberType FROM Person p RIGHT JOIN p.contactDetails ph")
	//@Query("SELECT p.pid, p.pname, p.paddrs, ph.regNo, ph.mobileNo, ph.provider, ph.numberType FROM Person p LEFT JOIN p.contactDetails ph")

	// Full Join is not supported in MYSQL
	@Query(value = "SELECT p.pid, p.pname, p.paddrs, ph.reg_no, ph.mobile_no, ph.provider, ph.number_type " +
	        "FROM jpa_otm_person p LEFT JOIN jpa_otm_phone_number ph ON p.pid = ph.person_id", nativeQuery = true)
	public List<Object[]> fetchDataUsingJoinsByParent();
	
	
}
