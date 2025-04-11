package com.nt.runners;

import java.util.Arrays;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IOToMAssociationMgmtService;

@Component
public class AssociationMappingUsingJoinsTestRunners implements CommandLineRunner {

	@Autowired
	private IOToMAssociationMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		// service.saveDataUsingParent();
		
				service.fetchDataUsingJoinsByParent().forEach(row -> {
					for (Object val : row) {
						System.out.println(val + " ");
				
					}
					System.out.println();
				});

		
	}
}
