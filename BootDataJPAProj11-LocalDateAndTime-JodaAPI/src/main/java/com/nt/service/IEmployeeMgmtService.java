package com.nt.service;

import java.util.List;

import com.nt.entity.Employee_Date_Time;

public interface IEmployeeMgmtService {

	// save Employee
	public String saveEmployee(Employee_Date_Time datetime);
	
	// gett all Employee
	public List<Employee_Date_Time> getAllEmployees();
	
	// show Employee desg
	public List<Integer> showEmployeeAgesByDesg(String desg);
	
	// get age from eno
	public float getAgeByeno(int eno);
}
