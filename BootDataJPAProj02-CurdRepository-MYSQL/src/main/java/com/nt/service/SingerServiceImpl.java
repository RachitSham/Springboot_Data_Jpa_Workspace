package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.ISingerRepo;
import com.nt.entity.Singer;

@Service("singer")
public class SingerServiceImpl implements ISingerService {

	@Autowired
	private ISingerRepo repoSinger;

	@Override
	public String registerSinger(Singer singer) {

		System.out.println("Singer Id (before save::" + singer.getSid());

		Singer sing = repoSinger.save(singer);
		return "Singer object is saved with id Value " + sing.getSid();
	}

	@Override
	public long showSingersCount() {
		long count = repoSinger.count();
		return count;
	}

	@Override
	public boolean checkSingerAvailability(int id) {
		boolean flag = repoSinger.existsById(id);
		return flag;
	}

	@Override
	public String registerSingerBatch(List<Singer> list) {
		// save the objects
		Iterable<Singer> savedList = repoSinger.saveAll(list);
		List<Integer> id = StreamSupport.stream(savedList.spliterator(), false).map(Singer::getSid)
				.collect(Collectors.toList());
		return id.size() + "No. of Singer have registered having the ids values " + id;
	}

	@Override
	public Iterable<Singer> showAllSinger() {
		return repoSinger.findAll();
	}

	@Override
	public Iterable<Singer> showAllSingerById(Iterable<Integer> id) {
		return repoSinger.findAllById(id);
	}

	@Override
	public Singer showSingerById(Integer id) {
		Singer favSinger = repoSinger.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid SInger Id"));
		return favSinger;
	}

	@Override
	public String registerOrUpdateSinger(Singer singer) {
		repoSinger.save(singer);
		return "Singer is Save/Update";
	}

	@Override
	public String updateSingerFees(int sid, Double newFees) {
		Optional<Singer> opt = repoSinger.findById(sid);
		if (opt.isPresent()) {
			// get Singer object from Optional Object
			Singer sing = opt.get();
			sing.setFees(newFees);
			repoSinger.save(sing);
			return sid + " Singer Fees Is Updated ";
		}
		return sid + "Singer is Not Found For Updation";
	}

	@Override
	public String deleteSingerById(Integer id) {
		Optional<Singer> opt = repoSinger.findById(id);
		if (opt.isPresent()) {
			repoSinger.deleteById(id);
			return id + " Singer Id is Deleted ";
		} else {
			return id + "Singer not for Deletion";
		}
	}

	@Override
	public String deleteSinger(Singer singer) {
		Optional<Singer> opt = repoSinger.findById(singer.getSid());
		if (opt.isEmpty()) {
			return singer.getSid() + "Singer Not Found";
		} else {
			repoSinger.delete(opt.get());
			return singer.getSid() + " Singer Found and deleted ";
		}

	}

	@Override
	public String removeAllDoctors() {
		long count = repoSinger.count();
		if (count > 0) {
			repoSinger.deleteAll();
			return count + "No.of records are deleted";
		}
		return "No records found deleted";
	}

	@Override
	public String removeSingerAllByIds(Iterable<Integer> ids) {
		// Load the objects by ids
		Iterable<Singer> list = repoSinger.findAllById(ids);
		long count = StreamSupport.stream(list.spliterator(), false).count();
		repoSinger.deleteAllById(ids);
		return count + " No. Of Singer are Deleted";
	}

	@Override
	public String removeSingerById(int id) {
		Optional<Singer> opt = repoSinger.findById(id);
		if (opt.isPresent()) {
			repoSinger.deleteById(id);
			return id + "  Doctor Found And Deleted";
		}
		return id + " Doctor Not found for Deletion ";
	}

}
