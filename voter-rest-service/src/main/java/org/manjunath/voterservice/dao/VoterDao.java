package org.manjunath.voterservice.dao;

import java.util.List;

import org.manjunath.voterservice.model.Voter;

public interface VoterDao {
	List<Voter> getAllVoters();
	
	Voter getVoterById(int id);
	
	void addVoter(Voter voter);
	
	void updateVoter(Voter voter);
	
	Voter deleteVoter(int id);
}
