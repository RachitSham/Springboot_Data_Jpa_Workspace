package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorService;

@Component
public class QuerryMethodTestRunner implements CommandLineRunner{

	@Autowired
	private IDoctorService docService;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*	Doctor doc = new Doctor("Prashant"	,	"Gastroenterologist", 110790.89);
			String msg = docService.registerAllDoctors(doc);
			System.out.println(msg);*/
	}

}
