package com.nt.runner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorService;

@Component
public class CurdRepoTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorService service;

	@Override
	public void run(String... args) throws Exception {

		Doctor doc = new Doctor();
		doc.setDocName("Mahi");
		doc.setSpecialization("Diagnostic Radiology");
		doc.setIncome(156790.89);
		
		String msg = service.registerDoctor(doc);
		System.out.println(msg);

		/*	try {
				System.out.println("Doctor Count::" + service.showDoctorCount());
			} catch (Exception e) {
				e.printStackTrace();
			}*/

		// SaveAll the Doctor records
		/*Doctor doc1 = new Doctor();
		doc1.setDocName("Tanuj");
		doc1.setSpecialization("Pulmonologist");
		doc1.setIncome(154000.90);
		
		Doctor doc2 = new Doctor();
		doc2.setDocName("Mahi");
		doc2.setSpecialization("Gastroenterologist");
		doc2.setIncome(155000.88);
		
		Doctor doc3 = new Doctor();
		doc3.setDocName("Nikhil");
		doc3.setSpecialization("Pathology");
		doc3.setIncome(144000.00);
		
		List<Doctor> list = List.of(doc1, doc2, doc3);
		try {
		
			String msg = service.registerDoctorBatch(list);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/

		// calling the b.method from doctorserviceImpl class to check availability.
		try {
			System.out.println("Doctor is Available or Not ? " + service.checkDoctorAvailability(116));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Iterable<Doctor> it = service.showAllDoctors();
			it.forEach(doc1 -> {
				System.out.println(doc1);
			});

			System.out.println("----------------------------------------------------------------------------");

			it.forEach(doc1 -> System.out.println(doc1));

			System.out.println("----------------------------------------------------------------------------");
			it.forEach(System.out::println);

			System.out.println("----------------------------------------------------------------------------");
			for (Doctor doc1 : it) {
				System.out.println(doc1);
			}

			System.out.println("----------------------------------------------------------------------------");
			StreamSupport.stream(it.spliterator(), false).forEach(System.out::println);

			System.out.println("----------------------------------------------------------------------------");
			long count = StreamSupport.stream(it.spliterator(), false).count();
			System.out.println("No. of records ::" + count);

			System.out.println("----------------------------------------------------------------------------");
			Iterable<String> specializationList = StreamSupport.stream(it.spliterator(), false)
					.map(Doctor::getSpecialization).collect(Collectors.toList());
			System.out.println(specializationList);

			Iterable<Double> doctor_Income = StreamSupport.stream(it.spliterator(), false).map(Doctor::getIncome)
					.collect(Collectors.toList());
			System.out.println(doctor_Income);

			System.out.println("----------------------------------------------------------------------------");
			List<Doctor> doc1 = StreamSupport.stream(it.spliterator(), false).toList();
			for (int i = 0; i < count; i++) {
				System.out.println(doc1.get(5));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("----------------------------------------------------------------------------");
		try {
			service.showAllDoctorsByIds(List.of(101, 102, 110, 107, 109, 111)).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("----------------------------------------------------------------------------");

		try {
			Doctor doctor = service.showDoctorById(116);
			System.out.println(doctor);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		System.out.println("----------------------------------------------------------------------------");
		/*
		try {
			Doctor doc = new Doctor();
			doc.setDocId(115);
			doc.setDocName("Mahi");
			doc.setSpecialization("Diagnostic Radiology");
			doc.setIncome(1550000.90);
		
			System.out.println(service.registerOrUpdateDoctors(doc));
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*
				System.out.println("----------------------------------------------------------------------------");
				try {
					String doctor_msg = service.updateDoctorIncome(102, 2500000.80);
					System.out.println(doctor_msg);
				} catch (Exception e) {
					e.printStackTrace();
				}*/
		/*
				System.out.println("----------------------------------------------------------------------------");
				try {
					System.out.println(service.deleteDoctorById(118));
				} catch (Exception e) {
					e.printStackTrace();
				}
		*/

		/*System.out.println("----------------------------------------------------------------------------");
		try {
			Doctor doc = new Doctor();
			doc.setDocId(111);
			doc.setDocName("Tanuj");
			System.out.println(service.deleteDoctor(doc));
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*System.out.println("----------------------------------------------------------------------------");
		try {
			System.out.println(service.removeAllDoctors());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			
			System.out.println("Doctor Count::" + service.removeDoctorsByIds(Arrays.asList(126, 127)));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			System.out.println(service.removeDoctorById(123));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
