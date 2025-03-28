package com.nt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Service("docService")
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public String deleteDoctorsByIdsInBatch(List<Integer> ids) {

		// Load the Entities
		List<Doctor> list = doctorRepo.findAllById(ids);

		// delete the entities
		doctorRepo.deleteAllByIdInBatch(ids);

		return list.size() + " Records are deleted ";
	}

	@Override
	public List<Doctor> showDoctorsByExampleDate(Doctor exDoctor, boolean ascOrder, String... properties) {
		// prepare sort object
		Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC, properties);
		
		// prepare Example Object
		Example example = Example.of(exDoctor);

		// use the repo
		List<Doctor> list = doctorRepo.findAll(example, sort);
		
		// return the collection
		return list;
	}

	@Override
	public Doctor findDoctoryId(Integer id) {
		Doctor doctor = doctorRepo.getReferenceById(id);
		return doctor;
	}

}
