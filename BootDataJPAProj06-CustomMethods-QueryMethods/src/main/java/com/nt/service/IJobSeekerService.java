package com.nt.service;

import java.util.List;

import com.nt.entity.JobSeeker;

public interface IJobSeekerService {

	/*// show all job seekers
	public String registerJobSeekerBatch(List<JobSeeker> list);*/

	// show all job seeker by name
	public List<JobSeeker> findByJsNameAndQlfy(String name, String qlfy);
	
	public List<JobSeeker> findByPercentageBetween(double minPercentage, double maxPercentage);
	
	
}
