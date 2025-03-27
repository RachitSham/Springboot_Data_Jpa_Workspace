package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorService {

	// Insert the data
	public String registerDoctor(Doctor doctor);

	// count data in the table
	public long showDoctorCount();

	// This method is for bulk Object insertion
	public String registerDoctorBatch(List<Doctor> list);

	// check Doctor by Id
	public boolean checkDoctorAvailability(int id);

	// Gives All the records of the table
	public Iterable<Doctor> showAllDoctors();

	// to get multiple records based on given ids
	public Iterable<Doctor> showAllDoctorsByIds(Iterable<Integer> ids);

	// Optional Findbyid
	public Doctor showDoctorById(Integer id);

	// Full Object Modification or Insertion
	public String registerOrUpdateDoctors(Doctor doctor);

	// Partially Update Modification
	public String updateDoctorIncome(int doc_id, double newIncome);

	// Delete the entity with given id
	public String deleteDoctorById(Integer id);

	// Delete a given Entity
	public String deleteDoctor(Doctor doctor);

	// delete all records of the db table
	public String removeAllDoctors();

	// delete the multiple records of db table based on given id
	public String removeDoctorsByIds(Iterable<Integer> ids);

	// delete the record with the given id
	public String removeDoctorById(int id);
}
