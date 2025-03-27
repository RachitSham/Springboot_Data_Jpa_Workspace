package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Service("docService")
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public String registerDoctor(Doctor doctor) {
		System.out.println("Doc Id(before save::" + doctor.getDocId());

		// use repo
		Doctor doc = doctorRepo.save(doctor);
		return "Doctor object is saved with id Value :" + doc.getDocId();
	}

	// Count the Doctor
	@Override
	public long showDoctorCount() {
		long count = doctorRepo.count();
		return count;
	}

	@Override
	public String registerDoctorBatch(List<Doctor> list) {
		// Save the Objects
		Iterable<Doctor> savedList = doctorRepo.saveAll(list);
		List<Integer> ids = StreamSupport.stream(savedList.spliterator(), false).map(Doctor::getDocId)
				.collect(Collectors.toList());
		return ids.size() + "No. of Doctors are Registered having the idValues " + ids;
	}

	@Override
	public boolean checkDoctorAvailability(int id) {
		boolean flag = doctorRepo.existsById(id);
		return flag;
	}

	@Override
	public Iterable<Doctor> showAllDoctors() {
		return doctorRepo.findAll();
	}

	@Override
	public Iterable<Doctor> showAllDoctorsByIds(Iterable<Integer> ids) {
		return doctorRepo.findAllById(ids);
	}

	/*@Override
	public Doctor showDoctorById(Integer id) {
		Optional<Doctor> opt = doctorRepo.findById(id);
		
		if(opt.isPresent())
			return opt.get();
		else
			throw new IllegalArgumentException("Invalid Doctor Id");
	}*/

	// best version
	public Doctor showDoctorById(Integer id) {
		Doctor doctor = doctorRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Dctor Id"));
		return doctor;
	}

	@Override
	public String registerOrUpdateDoctors(Doctor doctor) {
		// save or update object
		doctorRepo.save(doctor);
		return "Doctor is saved/update";
	}

	@Override
	public String updateDoctorIncome(int doc_id, double newIncome) {
		Optional<Doctor> opt = doctorRepo.findById(doc_id);
		if (opt.isPresent()) {
			// get Singer object from Optional Object
			Doctor doc = opt.get();
			doc.setIncome(newIncome);
			return doc_id + "Doctor Income is Updated ";

		}
		return doc_id + "Doctor is not Found for Updation ";
	}

	@Override
	public String deleteDoctorById(Integer id) {
		Optional<Doctor> opt = doctorRepo.findById(id);
		if (opt.isPresent()) {
			doctorRepo.deleteById(id);
			return id + " Doctor Id is Deleted ";
		} else {
			return id + " Doctor Not Found for Deletion ";
		}
	}

	@Override
	public String deleteDoctor(Doctor doctor) {
		Optional<Doctor> opt = doctorRepo.findById(doctor.getDocId());
		if (opt.isEmpty()) {

			return doctor.getDocId() + " Doctor is not Found ";

		} else {
			doctorRepo.delete(opt.get());
			return doctor.getDocId() + " Doctor is Found and Deleted ";
		}
	}

	@Override
	public String removeAllDoctors() {
			long count = doctorRepo.count();
			if(count>0) {
				doctorRepo.deleteAll();
				return count + " No. of Records are Delete";
			}
		return count + " No Records found and Deleted";
	}
	
	@Override
	public String removeDoctorsByIds(Iterable<Integer> ids) {
		//Load the Obj by ids
		Iterable<Doctor> list = doctorRepo.findAllById(ids);
		long count = StreamSupport.stream(list.spliterator(), false).count();
		
		// delete obj by ids
		doctorRepo.deleteAllById(ids);
		return count + " No. of doctor are deleted ";
	}
	
	@Override
	public String removeDoctorById(int id) {
	Optional<Doctor> opt= doctorRepo.findById(id);
	if (opt.isPresent()) {
		doctorRepo.deleteById(id);
		
		return id + " Doctor Found and Deleted";
	}
		return id + " Paitenet is not found Deletion ";
	}
}
