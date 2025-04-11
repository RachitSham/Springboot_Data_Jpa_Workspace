package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorService;

@Component
public class CallingPLSQLProcedureTest implements CommandLineRunner {

	@Autowired
	private IDoctorService service;
	
	@Override
	public void run(String... args) throws Exception {
				
	//invoke b.method of service
		service.showDoctorByIncomeRange(100000, 220000).forEach(System.out::println);

	}

}
