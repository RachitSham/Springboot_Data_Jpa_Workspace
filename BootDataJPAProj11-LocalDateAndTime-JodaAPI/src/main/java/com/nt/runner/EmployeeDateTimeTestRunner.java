package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee_Date_Time;
import com.nt.service.IEmployeeMgmtService;

@Component
public class EmployeeDateTimeTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService empService;

	@Override
	public void run(String... args) throws Exception {

		/*try {
			// save the employee
			Employee_Date_Time emp = new Employee_Date_Time("Rachit", "Manger", LocalDateTime.of(1999, 8, 15, 1, 10),
																				 LocalTime.of(1, 15),  
																				 LocalDate.of(2025, 4, 10));
		
			String result = empService.saveEmployee(emp);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		// get All Employee
		/*System.out.println("---------------------------------------------------------------------------------------");
		try {
			empService.getAllEmployees().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		// show Employee by desg
		/*System.out.println("---------------------------------------------------------------------------------------");
		try {
			empService.showEmployeeAgesByDesg("Salesman").forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		System.out.println("---------------------------------------------------------------------------------------");
		try {
			System.out.println("Employee Age is :- " + empService.getAgeByeno(452));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
