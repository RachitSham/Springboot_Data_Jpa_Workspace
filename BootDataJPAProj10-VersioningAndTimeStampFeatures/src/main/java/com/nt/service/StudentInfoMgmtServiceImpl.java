package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.StudentInfo;
import com.nt.repository.IStudentInfoRepository;

@Service("studentInfo")
public class StudentInfoMgmtServiceImpl implements IStudentInfoMgmtService {

	@Autowired
	private IStudentInfoRepository studentInfoRepository;

	@Override
	public String saveStudentCourseInfo(StudentInfo info) {
		Integer idVal = studentInfoRepository.save(info).getSId();
		return "Student Info is Saved With the Id Value:: " + idVal;
	}

	@Override
	public String updateStudentInfoById(Integer sid, String cName, String sEmail) {
		Optional<StudentInfo> opt = studentInfoRepository.findById(sid);
		if (opt.isPresent()) {
			StudentInfo info = opt.get();
			info.setCName(cName);
			info.setSEmail(sEmail);

			StudentInfo data = studentInfoRepository.save(info);
			return "Student Info is Updated for " + data.getUpdateCount() + "Times Lastly Modified On: "
					+ data.getLastlyCourseUpdatedOn() + ".....Created On " + data.getCourseOptedOn();

		} else {
			return " Student Info Is Not found";

		}
	}

	@Override
	public StudentInfo showStudentDetailsById(Integer id) {
		return studentInfoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Student Info Id not Found "));
	}

}
