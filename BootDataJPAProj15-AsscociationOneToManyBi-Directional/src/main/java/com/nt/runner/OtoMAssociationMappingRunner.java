package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IOToMAssociationMgmtService;

@Component
public class OtoMAssociationMappingRunner implements CommandLineRunner {

	@Autowired
	private IOToMAssociationMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		// service.saveDataUsingParent();

		// service.saveDataUsingChild();

		// service.LoadDataUsingParent();

		// service.LoadDataUsingChild();

		/*String msg =  service.deleteByPerson(1);
		System.out.println(msg);*/

		/*String delete_msg = service.deleteAllPhoneNumbersOfAPerson(2);
		System.out.println(delete_msg);*/

		// service.addNewChildToAParentById(2);

		// service.deleteDataUsingChilds();
	}

}
