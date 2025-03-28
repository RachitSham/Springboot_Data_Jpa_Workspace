package com.nt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Singer;

public interface ISingerRepo extends PagingAndSortingRepository<Singer, Integer> {

}
