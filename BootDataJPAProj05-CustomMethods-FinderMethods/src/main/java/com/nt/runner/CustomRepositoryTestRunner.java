package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepo;

@Component
public class CustomRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public void run(String... args) throws Exception {

		doctorRepo.findByDocNameEquals("Rachit").forEach(System.out::println);

		System.out.println(" ----------------------------------------- ");
		// doctorRepo.findByDocNamels("Prashant").forEach(System.out::println);

		System.out.println(" ----------------------------------------- ");
		doctorRepo.findByDocName("Akshat").forEach(System.out::println);

		System.out.println(" ----------------------------------------- ");
		doctorRepo.findByDocNameStartingWith("Ni").forEach(System.out::println);

		System.out.println(" ----------------------------------------- ");
		doctorRepo.findByDocNameEndingWith("t").forEach(System.out::println);

				System.out.println(" ----------------------------------------- ");
				doctorRepo.findByDocNameContaining("a").forEach(System.out::println);
		
				System.out.println(" ----------------------------------------- ");
				doctorRepo.findByDocNameEqualsIgnoreCase("aaA").forEach(System.out::println);
		
					System.out.println(" ----------------------------------------- ");
					doctorRepo.findByDocNameContainingIgnoreCase("a").forEach(System.out::println);
				
					System.out.println(" ----------------------------------------- ");
					doctorRepo.findByDocNameLike("S%").forEach(System.out::println);
					System.out.println(" ----------------------------------------- ");
					doctorRepo.findByDocNameLike("________").forEach(System.out::println);
					System.out.println(" ----------------------------------------- ");
					doctorRepo.findByDocNameLike("%R").forEach(System.out::println);
					System.out.println(" ----------------------------------------- ");
					doctorRepo.findByDocNameLike("%S%").forEach(System.out::println);
		}
}
