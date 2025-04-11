package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service("service")
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepository docRepository;

	@Override
	public String registerAllDoctors(Doctor doctor) {
		System.out.println("Doc Id(before save::" + doctor.getDocId());

		// use repo
		Doctor doc = docRepository.save(doctor);
		return "Doctor object is saved with id Value :" + doc.getDocId();
	}
}
