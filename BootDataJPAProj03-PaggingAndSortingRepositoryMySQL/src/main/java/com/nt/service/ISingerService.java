package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Singer;

public interface ISingerService {

	public Iterable<Singer> showSingerBySorting(boolean asc, String...props);
	
	public Page<Singer> showSingerInfoByPageNo(int pageNO, int pageSize, boolean ascOrder, String props);
}
