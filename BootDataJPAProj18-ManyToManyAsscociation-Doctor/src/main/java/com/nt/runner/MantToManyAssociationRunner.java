package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;
import com.nt.service.IHospitalMgmtService;

@Component
public class MantToManyAssociationRunner implements CommandLineRunner {

	@Autowired
	private IHospitalMgmtService hospitalService;

	@Override
	public void run(String... args) throws Exception {

		try {
			Doctor doc1 = new Doctor();
			Doctor doc2 = new Doctor();
			doc1.setDname("Arnav Roy"); doc1.setSpecialization("Endocrinologist");	
			doc2.setDname("Rachit Sharma"); doc2.setSpecialization("Orthopedic Surgeon");
			
			Patient pat1 = new Patient();
			Patient pat2 = new Patient();
			Patient pat3 = new Patient();
			pat1.setPname("David"); pat1.setProblem("fractures");
			pat2.setPname("Jerry"); pat2.setProblem("Lung diseases");
			pat3.setPname("Peter"); pat3.setProblem("kidney stones ");
			
			doc1.setPatients(List.of(pat1, pat2));
			doc2.setPatients(List.of(pat1, pat2, pat3));
			
			// invoke the b.method
			String msg_doctor = hospitalService.saveDoctorAndPatients(List.of(doc1, doc2));
			System.out.println(msg_doctor);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Doctor doc1 = new Doctor();
			Doctor doc2 = new Doctor();
			doc1.setDname("Ravi Singh"); doc1.setSpecialization("Family Practitioner");
			doc2.setDname("Himanshu Sharma"); doc2.setSpecialization("Orthopedic Surgeon");
			
			Patient pat1 = new Patient();
			Patient pat2 = new Patient();
			Patient pat3 = new Patient();
			
			pat1.setPname("Sachin"); pat1.setProblem("common illnesses");
			pat2.setPname("Raghav"); pat2.setProblem("joint replacements");
			pat3.setPname("Ram"); pat3.setProblem("General health");
		
			pat1.setDoctors(List.of(doc1, doc2));
			pat2.setDoctors(List.of(doc1));
			pat3.setDoctors(List.of(doc1, doc2));
		
			// invoke b.method
			String msg_patient = hospitalService.savePatientAndDoctor(List.of(pat1, pat2, pat3));
			System.out.println(msg_patient);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*try {
			hospitalService.shoeDoctorsAndTheirPatients().forEach(doc -> {
				System.out.println("Parent:: " + doc);
		
				// get childs of each parent
				List<Patient> list = doc.getPatients();
				list.forEach(pat -> {
					System.out.println("Child:: " + pat);
				});
			});
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		System.out.println(" -------------------------------------------------------------------------------------- ");
		
		/*try {
			hospitalService.shoePatientAndTheirDoctors().forEach(pat -> {
				System.out.println("Child:: " + pat);
		
				// get parent of each child
				List<Doctor> list = pat.getDoctors();
				list.forEach(doc -> {
					System.out.println("Parent:: " + doc);
				});
			});
		
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			String remove_patients =  hospitalService.removeCertainPaitentsFromDoctor(52, 1003, 1004);
					System.out.println(remove_patients);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
