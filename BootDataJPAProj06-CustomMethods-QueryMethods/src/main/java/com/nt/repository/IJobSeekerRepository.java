package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.JobSeeker;

public interface IJobSeekerRepository extends JpaRepository<JobSeeker, Integer> {

	@Query("SELECT j FROM JobSeeker j WHERE j.jsName = :name AND j.qlfy = :qlfy")
	List<JobSeeker> findByJsNameAndQlfy(String name, String qlfy);

	// @Query("SELECT j FROM JobSeeker j WHERE j.percentage BETWEEN :minPercentage AND :maxPercentage")
	//@Query("FROM com.nt.entity.JobSeeker WHERE percentage BETWEEN :minPercentage AND :maxPercentage")
	@Query("FROM JobSeeker job WHERE percentage BETWEEN :minPercentage AND :maxPercentage")
	public List<JobSeeker> searchJobSeekerByPercentageRange(@Param("minPercentage") double minPercentage,
															@Param("maxPercentage") double maxPercentage);
	
	
	
}
