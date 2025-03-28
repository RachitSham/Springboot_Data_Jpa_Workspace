package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorService;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorService docService;

	@Override
	public void run(String... args) throws Exception {

		/*System.out.println(docService.deleteDoctorsByIdsInBatch(List.of(129, 130)));
		
		// throws exception because List.off() does not allow null element...
		System.out.println(docService.deleteDoctorsByIdsInBatch(List.of(128, null)));
		
		// Does not throw any Exception
		System.out.println(docService.deleteDoctorsByIdsInBatch(Arrays.asList(125, null)));*/

		System.out.println(" ---------------------------------------------------------------------- ");
		
		Doctor doctor = new Doctor();
		doctor.setSpecialization("Gastroenterologist");
		doctor.setIncome(110790.89);
		docService.showDoctorsByExampleDate(doctor, true, "income").forEach(System.out::println);

		System.out.println(" ---------------------------------------------------------------------- ");
		
		System.out.println(docService.findDoctoryId(117));
	}
}
