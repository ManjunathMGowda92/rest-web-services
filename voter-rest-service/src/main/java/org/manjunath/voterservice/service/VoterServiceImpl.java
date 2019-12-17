package org.manjunath.voterservice.service;

import java.util.ArrayList;
import java.util.List;

import org.manjunath.voterservice.model.Address;
import org.manjunath.voterservice.model.Voter;

public class VoterServiceImpl implements VoterService {

	@Override
	public List<Voter> getAllVoters() {
		List<Voter> voterList = new ArrayList<>();
		voterList.add(new Voter(1, "ADGAGD", "Manjunath", "HM", "Munikrishnappa", "", "10/02/1992", "MALE", new Address()));
		voterList.add(new Voter(2, "ADGAGD", "Manoj", "HM", "Munikrishnappa", "", "27/10/1996", "MALE", new Address()));
		
		return null;
	}
	
	
}
