package com.nt.service;

import java.util.List;

import com.nt.entity.Singer;

public interface ISingerService {

	// Insert the data
	public String registerSinger(Singer singer);

	// count the data in the table
	public long showSingersCount();

	// check Singer by Id
	public boolean checkSingerAvailability(int id);

	// This method is for bulk Object insertion
	public String registerSingerBatch(List<Singer> list);

	// Gives All the records of the table
	public Iterable<Singer> showAllSinger();

	// to get multiple records based on given ids
	public Iterable<Singer> showAllSingerById(Iterable<Integer> id);

	// Optional Findbyid
	public Singer showSingerById(Integer id);

	// full object modification or insertion
	public String registerOrUpdateSinger(Singer singer);

	// Partially Object Modification
	public String updateSingerFees(int sid, Double fees);

	// Delete the entity with given id
	public String deleteSingerById(Integer id);

	// Delete a given Entity
	public String deleteSinger(Singer singer);

	// delete all records of the db table
	public String removeAllDoctors();

	// delete the multiple records of db table based on given id
	public String removeSingerAllByIds(Iterable<Integer> ids);

	// delete the record with the given id
	public String removeSingerById(int id);
}
