package com.nt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

/*
 * MySQL does not support cursors as output parameters like Oracle.
 * 
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_DOCTORS_BY_INCOME_RANGE`(
    IN STARTINCOME FLOAT,
    IN ENDINCOME FLOAT
	)
	BEGIN
    SELECT * FROM JPA_DOCTOR_INFO 
    WHERE INCOME BETWEEN STARTINCOME AND ENDINCOME;
	END
 * 
*/

@Service("docService")
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private EntityManager manager;

	@Override
	public List<Doctor> showDoctorByIncomeRange(double start, double end) {
		// create stored procedures Query Object pointing pl/sql procedure
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_DOCTORS_BY_INCOME_RANGE", Doctor.class);

		// register both IN, OUT Params by specifying their node
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		
		// set values ti IN params
		query.setParameter(1, start);
		query.setParameter(2, end);

		// call PL/SQL procedure
		List<Doctor> list = query.getResultList();
		return list;
	}

}
