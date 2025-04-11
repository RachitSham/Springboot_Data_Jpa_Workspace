package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.StudentInfo;
import com.nt.service.IStudentInfoMgmtService;

@Component
public class VersioningAndTimeStampTestRunner implements CommandLineRunner {

	@Autowired
	private IStudentInfoMgmtService studentInfoService;

	@Override
	public void run(String... args) throws Exception {

		/*try {
			StudentInfo info = new StudentInfo("Shantanu", "ReactJS", "shantanu890dev@gamil.com",9987765410l);
			System.out.println(studentInfoService.saveStudentCourseInfo(info));
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		System.out.println(" ----------------------------------------------------------------------------------------------------------------- ");
		try {
			System.out.println(studentInfoService.updateStudentInfoById(2, "SpringBoot + Oracle + JRTP", "sharma8080rachit@gmail.com"));
			System.out.println(studentInfoService.showStudentDetailsById(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(" ----------------------------------------------------------------------------------------------------------------- ");
		try {
			System.out.println(studentInfoService.updateStudentInfoById(6, "React + Oracle", "shantanu890dev@gamil.com"));
			System.out.println(studentInfoService.showStudentDetailsById(6));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println(" ----------------------------------------------------------------------------------------------------------------- ");
		try {
			System.out.println(studentInfoService.showStudentDetailsById(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" ----------------------------------------------------------------------------------------------------------------- ");
		
		
	}
}
