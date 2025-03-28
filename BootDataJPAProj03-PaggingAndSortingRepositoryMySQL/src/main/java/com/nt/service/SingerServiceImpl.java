package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Singer;
import com.nt.repository.ISingerRepo;

@Service("singer")
public class SingerServiceImpl implements ISingerService {

	@Autowired
	private ISingerRepo repoSinger;

	@Override
	public Iterable<Singer> showSingerBySorting(boolean asc, String... props) {
		// prepare the sort Object
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC,props);
		// Use repo
		Iterable<Singer> it = repoSinger.findAll(sort);
		return it;
	}

	@Override
	public Page<Singer> showSingerInfoByPageNo(int pageNO, int pageSize, boolean ascOrder, String props) {
		// prepare the sort object
		Sort sort = Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		
		// Prepare Pageable Object
		Pageable pageable = PageRequest.of(pageNO, pageSize, sort);
		
		// use the repo
		Page<Singer> page = repoSinger.findAll(pageable);
		return page;
	}

}
