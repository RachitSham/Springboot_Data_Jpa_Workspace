package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nt.entity.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor, Integer>{

}
