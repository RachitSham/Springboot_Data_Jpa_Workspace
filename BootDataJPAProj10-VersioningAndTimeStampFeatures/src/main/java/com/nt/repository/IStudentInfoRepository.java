package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.StudentInfo;

public interface IStudentInfoRepository extends JpaRepository<StudentInfo, Integer>{

}
