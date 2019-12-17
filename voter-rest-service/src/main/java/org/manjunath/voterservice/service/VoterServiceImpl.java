package org.manjunath.voterservice.service;

import java.util.List;

import org.manjunath.voterservice.dao.VoterDao;
import org.manjunath.voterservice.dao.VoterDaoImpl;
import org.manjunath.voterservice.model.Voter;

public class VoterServiceImpl implements VoterService {	

	@Override
	public List<Voter> getAllVoters() {
		List<Voter> voterList = getDaoInstance().getAllVoters();
		return voterList;
	}
	
	private VoterDao getDaoInstance(){
		return VoterDaoImpl.getInstance();
	}
	
	
}
