package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("loginService")
public class LoginMgmtServiceImpl implements ILoginMgmtService {

	@Autowired
	private EntityManager manager;

	/*
	CREATE DEFINER=`root`@`localhost` PROCEDURE `p_authentication`(in uname varchar(20),
	in pwd varchar(20),
	out result varchar(20))
	BEGIN
	declare cnt int(2);
	
	SELECT 
	COUNT(*)
	INTO cnt FROM
	login_info
	WHERE
	username = uname AND password = pwd;
	if(cnt<>0) then
	set result = "Valid Credentials";
	else
	set result = "InValid Credentials";
	end if;
	END
	*/

	@Override
	public String doLogin(String user, String pwd) {
		// create stored procedure query object
		StoredProcedureQuery query = manager.createStoredProcedureQuery("p_authentication");

		// register the params
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);

		// set the param value
		query.setParameter(1, user);
		query.setParameter(2, pwd);

		// call the PL/ SQL Procedure
		String result = (String) query.getOutputParameterValue(3);
		return result;

	}

}
