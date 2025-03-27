package com.nt.Repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Singer;

public interface ISingerRepo extends CrudRepository<Singer, Integer> {

}
