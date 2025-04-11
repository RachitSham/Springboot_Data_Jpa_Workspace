package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CallerTuneInfo;

public interface ICallerTuneRepository extends JpaRepository<CallerTuneInfo, Integer>{

}
