package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee_Date_Time;
import com.nt.repository.EmployeeDateTimeRepository;

@Service("empservice")
public class EmployeeServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private EmployeeDateTimeRepository empRepository;

	@Override
	public String saveEmployee(Employee_Date_Time datetime) {
		int idVal = empRepository.save(datetime).getEno();
		return "Employee Data is Saved with the Id Value:: " + idVal;
	}

	@Override
	public List<Employee_Date_Time> getAllEmployees() {
		return empRepository.findAll();
	}

	@Override
	public List<Integer> showEmployeeAgesByDesg(String desg) {
		return empRepository.getEmployeeAgesByDesg(desg);
	}

	@Override
	public float getAgeByeno(int eno) {
		return empRepository.getAgeByEno(eno);
	}

}
