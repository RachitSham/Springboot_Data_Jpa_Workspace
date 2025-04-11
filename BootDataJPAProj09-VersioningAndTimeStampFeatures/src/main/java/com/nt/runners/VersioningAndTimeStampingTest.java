package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.CallerTuneInfo;
import com.nt.service.ICallerTuneMgmtService;

@Component
public class VersioningAndTimeStampingTest implements CommandLineRunner {

	@Autowired
	private ICallerTuneMgmtService callerTuneService;

	@Override
	public void run(String... args) throws Exception {

		// save the data in db table
		/*	try {
				CallerTuneInfo info = new CallerTuneInfo("Maaye ", "Sky Force");
				System.out.println(callerTuneService.saveCallerTuneInfo(info));
			} catch (Exception e) {
				e.printStackTrace();
			}*/

		System.out.println(" -------------------------------------------------------------------------------- ");
		try {
			System.out.println(callerTuneService.updateCallerTuneInfoById(1, " Ud-Daa Punjab", "Udta Punjab"));
			System.out.println(callerTuneService.showCallerTuneDetailsById(1));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(" -------------------------------------------------------------------------------- ");
		try {
			System.out.println(callerTuneService.updateCallerTuneInfoById(2, "Sanam Teri Kasam ", "Sanam Teri Kasam"));
			System.out.println(callerTuneService.showCallerTuneDetailsById(2));
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println(" -------------------------------------------------------------------------------- ");
		try {
			System.out.println(callerTuneService.showCallerTuneDetailsById(352));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(" -------------------------------------------------------------------------------- ");

	}

}
