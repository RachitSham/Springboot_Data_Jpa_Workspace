package com.nt.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeeker;
import com.nt.repository.IJobSeekerRepository;

@Service("jobservice")
public class JobSeekerServiceImpl implements IJobSeekerService {

	@Autowired
	private IJobSeekerRepository jobRepo;

	@Override
	public List<JobSeeker> findByJsNameAndQlfy(String name, String qlfy) {
		List<JobSeeker> list = jobRepo.findByJsNameAndQlfy(name, qlfy);
		return list;
	}

	@Override
	public List<JobSeeker> findByPercentageBetween(double minPercentage, double maxPercentage) {
		List<JobSeeker> list = jobRepo.searchJobSeekerByPercentageRange(minPercentage, maxPercentage);
		return list;
	}



	
	/*@Override
	 * save all() to save data in db
	public String registerJobSeekerBatch(List<JobSeeker> list) {
		Iterable<JobSeeker> savedList = jobRepo.saveAll(list);
		List<Integer> ids = StreamSupport.stream(savedList.spliterator(), false).map(JobSeeker::getJsId)
				.collect(Collectors.toList());
		return ids.size()+ "No. of Job Seekers are Registered having the idValues " + ids;
	}*/

}
