package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ILoginMgmtService;

@Component
public class CallingPLSQLProccedureTest implements CommandLineRunner {

	@Autowired
	private ILoginMgmtService loginservice;

	@Override
	public void run(String... args) throws Exception {

		try {
			// invoe the b.method
			String result = loginservice.doLogin("ravi", "ravi@123");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
