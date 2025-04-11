package com.nt.service;

import com.nt.entity.CallerTuneInfo;

public interface ICallerTuneMgmtService {

	public String saveCallerTuneInfo(CallerTuneInfo info);
	
	public String updateCallerTuneInfoById(Integer id, String tuneName, String MovieName);
	
	public CallerTuneInfo showCallerTuneDetailsById(Integer id);
}
