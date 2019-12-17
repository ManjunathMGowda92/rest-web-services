package org.manjunath.voterservice.service;

import java.util.List;

import org.manjunath.voterservice.model.Voter;

public interface VoterService {
	
	List<Voter> getAllVoters();
	
	Voter findVoterById(int id);
	
	void addVoter(Voter voter);
	
	void updateVoter(Voter voter);
	
	Voter deleteVoterById(int id);
}
