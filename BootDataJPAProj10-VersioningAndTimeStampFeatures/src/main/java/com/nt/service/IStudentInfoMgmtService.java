package com.nt.service;

import com.nt.entity.StudentInfo;

public interface IStudentInfoMgmtService {

	public String saveStudentCourseInfo(StudentInfo info);
	
	public String updateStudentInfoById(Integer sid, String cName, String sEmail);
	
	public StudentInfo showStudentDetailsById(Integer id);
}
