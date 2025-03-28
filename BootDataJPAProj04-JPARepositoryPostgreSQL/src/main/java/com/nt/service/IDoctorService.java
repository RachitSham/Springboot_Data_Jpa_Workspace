package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorService {

	public String deleteDoctorsByIdsInBatch(List<Integer> ids);

	public List<Doctor> showDoctorsByExampleDate(Doctor exDoctor, boolean ascOrder, String... properties);

	public Doctor findDoctoryId(Integer id);
}
