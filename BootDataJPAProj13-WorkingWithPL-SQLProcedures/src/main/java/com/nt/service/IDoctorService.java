package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorService {

	public List<Doctor> showDoctorByIncomeRange(double start, double end);

}
