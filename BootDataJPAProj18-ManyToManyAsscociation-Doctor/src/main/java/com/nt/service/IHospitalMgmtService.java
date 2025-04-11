package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;

public interface IHospitalMgmtService {

	// parent to child
	public String saveDoctorAndPatients(List<Doctor> list);
	// child to parent

	public String savePatientAndDoctor(List<Patient> list);

	// parent to child
	public List<Doctor> shoeDoctorsAndTheirPatients();

	// child to parent
	public List<Patient> shoePatientAndTheirDoctors();

	public String removeCertainPaitentsFromDoctor(int did, int pat1, int pat2);
}
