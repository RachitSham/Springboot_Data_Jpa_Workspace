package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Employee_Date_Time;

public interface EmployeeDateTimeRepository extends JpaRepository<Employee_Date_Time, Integer> {

	// @Query(value="SELECT YEAR(CURRENT_TIMESTAMP) -YEAR(dob) FROM EMPLOYEE_DATE_TIME WHERE desg=:desg", nativeQuery = true )
	@Query(value = "SELECT(TIMESTAMPDiff(DAY,dob, curdate()))/365.25 FROM EMPLOYEE_DATE_TIME WHERE  desg=:desg", nativeQuery = true)
	public List<Integer> getEmployeeAgesByDesg(String desg);

	// calculate age
	@Query(value = "SELECT DATEDIFF(CURDATE(), dob) / 365.25 FROM Employee_Date_Time WHERE eno=:eno", nativeQuery = true)
	public float getAgeByEno(int eno);

}
