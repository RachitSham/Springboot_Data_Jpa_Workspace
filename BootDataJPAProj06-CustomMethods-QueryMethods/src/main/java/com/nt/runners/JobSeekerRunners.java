package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.JobSeeker;
import com.nt.service.IJobSeekerService;

@Component
public class JobSeekerRunners implements CommandLineRunner {

	@Autowired
	private IJobSeekerService jobservice;

	@Override
	public void run(String... args) throws Exception {

		/*// SaveAll the Doctor records
		JobSeeker job1 = new JobSeeker("Shantanu Dev", "Master of Computer App", 88.67, 9876543210L);
		JobSeeker job2 = new JobSeeker("Emma Watson", "Bachelor of Engineering", 90.2, 7890123456L);
		JobSeeker job3 = new JobSeeker("Mayank Sharma", "B.Tech", 90.5, 6787657654L);
		
		List<JobSeeker> list = List.of(job1, job2, job3);
		try {
		
			String msg_job = jobservice.registerJobSeekerBatch(list);
			System.out.println(msg_job);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		System.out.println(" ---------------------------------------------------------------------------- ");
		jobservice.findByJsNameAndQlfy("Harshita", "Bachelor of Commerce").forEach(System.out::println);

		System.out.println(" ---------------------------------------------------------------------------- ");
		jobservice.findByPercentageBetween(60.2, 80.5).forEach(System.out::println);

		/*System.out.println(" ---------------------------------------------------------------------------- ");
		jobservice.findByPercentageBetween(70.90, 90.0).forEach(System.out::println);*/

	}

}
