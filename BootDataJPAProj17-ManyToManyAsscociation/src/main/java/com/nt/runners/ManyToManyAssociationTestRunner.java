package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ICollegeMgmtService;

@Component
public class ManyToManyAssociationTestRunner implements CommandLineRunner {

	@Autowired
	private ICollegeMgmtService collegeService;

	@Override
	public void run(String... args) throws Exception {

		/*try {
		
			collegeService.saveDataUsingParent();
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		

		
			try {
				collegeService.loadDataUsingParent();
			} catch (Exception e) {
				e.printStackTrace();
			}

		/*try {
			collegeService.deleteDataUsingParent();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
