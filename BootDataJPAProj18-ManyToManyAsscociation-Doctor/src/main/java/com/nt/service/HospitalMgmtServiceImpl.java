package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;
import com.nt.repository.IDoctorRepository;
import com.nt.repository.IPatientRepository;

@Service("hospitalService")
public class HospitalMgmtServiceImpl implements IHospitalMgmtService {

	@Autowired
	private IDoctorRepository doctorRepo;

	@Autowired
	private IPatientRepository patientRepo;

	@Override
	public String saveDoctorAndPatients(List<Doctor> list) {

		// save object parent to child
		List<Doctor> savedList = doctorRepo.saveAll(list);

		// get saved doctors id
		List<Integer> ids = savedList.stream().map(Doctor::getDid).collect(Collectors.toList());
		return ids + "Doctors and their Patients are Saved !! ";
	}

	@Override
	public String savePatientAndDoctor(List<Patient> list) {
		List<Patient> savedList = patientRepo.saveAll(list);

		List<Integer> ids = savedList.stream().map(Patient::getPid).collect(Collectors.toList());
		return ids + "Patients and their Doctors are saved";
	}

	@Override
	public List<Doctor> shoeDoctorsAndTheirPatients() {
		return doctorRepo.findAll();
	}

	@Override
	public List<Patient> shoePatientAndTheirDoctors() {
		return patientRepo.findAll();
	}

	@Override
	public String removeCertainPaitentsFromDoctor(int did, int pat1, int pat2) {
		// Load the given doctor
		Optional<Doctor> opt = doctorRepo.findById(did);
		if (opt.isPresent()) {
			Doctor doct = opt.get();

			// Get patients of the doctor
			List<Patient> list = doct.getPatients();
			list.removeIf(pat -> pat.getPid() == pat1 || pat.getPid() == pat2);

			// Update the doctor’s patient list
			doct.setPatients(list);

			// Save the updated doctor
			doctorRepo.save(doct);
			return "Patients are removed from the doctor";

		}
		return "Doctors not Found";
	}

}
