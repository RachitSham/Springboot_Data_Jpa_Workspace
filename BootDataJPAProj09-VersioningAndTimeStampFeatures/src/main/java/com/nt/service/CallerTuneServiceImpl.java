package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CallerTuneInfo;
import com.nt.repository.ICallerTuneRepository;

@Service("callertune")
public class CallerTuneServiceImpl implements ICallerTuneMgmtService {

	@Autowired
	private ICallerTuneRepository callerTuneRepo;

	@Override
	public String saveCallerTuneInfo(CallerTuneInfo info) {
		Integer idVal = callerTuneRepo.save(info).getTuneID();
		return "Caller Tune is Saved With the Id Value:: " + idVal;
	}

	@Override
	public String updateCallerTuneInfoById(Integer id, String tuneName, String MovieName) {
		Optional<CallerTuneInfo> opt = callerTuneRepo.findById(id);
		if (opt.isPresent()) {
			CallerTuneInfo info = opt.get();
			info.setTuneName(tuneName);
			info.setMovieName(MovieName);
			CallerTuneInfo tune = callerTuneRepo.save(info);
			return "Object is Updated For " + tune.getUpdateCount() + "times...Lastly Modified On:"
					+ tune.getLastlyUpdatedOn() + "......Created On ::" + tune.getServiceOptedOn();
		} else {
			return "Caller Tune Service is not found";

		}
	}

	@Override
	public CallerTuneInfo showCallerTuneDetailsById(Integer id) {
		return callerTuneRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Caller Tune Not Found "));
	}

}
