package com.nt.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Faculty;
import com.nt.entity.Student;
import com.nt.repository.IFacultyRepository;
import com.nt.repository.IStudentRepository;

@Service("mgmtservice")
public class CollegeMgmtServiceImpl implements ICollegeMgmtService {

	@Autowired
	private IFacultyRepository facultyRepo;

	@Autowired
	private IStudentRepository studentRepo;

	@Override
	public void saveDataUsingParent() {

		// create the parent object
		Faculty fa1 = new Faculty("Veerababu sir", "Hyderabad");
		Faculty fa2 = new Faculty("Vali Sir", "Hyderabad");

		// Create the child object
		Student sd1 = new Student("Nishant", "Kanpur", "MultiCloud");
		Student sd2 = new Student("Niharki", "Punjab", "DevOops");
		Student sd3 = new Student("Anil", "Bhopal", "DevSecTools");

		// assign student to faculty
		fa1.getStudentInfo().add(sd1);
		fa1.getStudentInfo().add(sd2);
		fa1.getStudentInfo().add(sd3);
		fa2.getStudentInfo().add(sd1);
		fa2.getStudentInfo().add(sd2);

		// assign faculty to student
		sd1.getFacultiesInfo().add(fa1);
		sd1.getFacultiesInfo().add(fa2);
		sd2.getFacultiesInfo().add(fa1);
		sd2.getFacultiesInfo().add(fa2);
		sd3.getFacultiesInfo().add(fa1);

		// save data using parent
		facultyRepo.save(fa1);
		facultyRepo.save(fa2);

		System.out.println("Faculties and Associated Student are Saved");
	}

	@Override
	public void loadDataUsingParent() {
		Iterable<Faculty> itFaculty = facultyRepo.findAll();
		itFaculty.forEach(Faculty -> {
			System.out.println("Parent_Data " + Faculty);

			Set<Student> childs = Faculty.getStudentInfo();
			childs.forEach(Student -> {
				System.out.println("Students_Data" + Student);
			});
		});
	}
	
	@Override
	public void deleteDataUsingParent() {
	Optional<Faculty> optional = facultyRepo.findById(3);
	if (optional.isPresent()) {
		Faculty faculty = optional.get();
		
		Set<Student> childs = faculty.getStudentInfo();
		faculty.setStudentInfo(null);
		childs.forEach(ch-> {
			ch.setFacultiesInfo(null);
		});
		facultyRepo.save(faculty);
		System.out.println("Faculty is Removed from Certain Students");
	}
	else {
		System.out.println("Faculty not found");
	}
	}
}
