package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer> {

}
