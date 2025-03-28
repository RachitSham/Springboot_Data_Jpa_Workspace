package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nt.entity.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {

	// select docId, docname, specialization, income from Doctor where docname=?
	public List<Doctor> findByDocNameEquals(String docname);

	// select docId, docname, specialization, income from Doctor where docname=?
	public List<Doctor> findByDocNameIs(String docname);

	// select docId, docname, specialization, income from Doctor where docname=?
	public Iterable<Doctor> findByDocName(String docname);
	
	// select docId, docname, specialization, income from Doctor where docname like'Ni%'
	public List<Doctor> findByDocNameStartingWith(String initChars);
	
	// select docId, docname, specialization, income from Doctor where docname like '%t'
	public Iterable<Doctor> findByDocNameEndingWith(String lastChars);
	
	// select docId, docname, specialization, income from Doctor where docname like '%dhe%'
	public Iterable<Doctor> findByDocNameContaining(String chars);
	
	// select docId, docname, specialization, income from Doctor where docname like '%dhe%'
	public Iterable<Doctor> findByDocNameEqualsIgnoreCase(String name);
	
	// select docId, docname, specialization, income from Doctor where docname like '%dhe%'
	public Iterable<Doctor> findByDocNameContainingIgnoreCase(String chars);
	
	// select docId, docname, specialization, income from Doctor where docname like '%dhe%'
	// select docId, docname, specialization, income from Doctor where docname like '%________%' // 8 leters DocName
	// select docId, docname, specialization, income from Doctor where docname like '%R%'
	// select docId, docname, specialization, income from Doctor where docname like '%S%'
	public Iterable<Doctor> findByDocNameLike(String chars);// pass wild chars while calling chars 
}
