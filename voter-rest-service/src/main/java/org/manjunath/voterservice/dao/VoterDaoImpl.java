package org.manjunath.voterservice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.manjunath.voterservice.model.Voter;

public class VoterDaoImpl implements VoterDao {
	private static VoterDao instance;
	private static Map<Integer, Voter> voterMap = new HashMap<>();

	static {
		try {
			instance = new VoterDaoImpl();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private VoterDaoImpl() throws IllegalAccessException {
		if (instance != null)
			throw new IllegalAccessException(
					getClass().getName() + ":Illegal way of accessing. It is a Singleton class");
	}

	public static VoterDao getInstance() {
		return instance;
	}

	@Override
	public List<Voter> getAllVoters() {
		return voterMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public Voter getVoterById(int id) {
		return voterMap.entrySet().stream().filter(entry -> entry.getKey() == id).findFirst().get().getValue();
	}

	@Override
	public void addVoter(Voter voter) {
		if (!voterMap.containsKey(voter.getId())) {
			voterMap.put(voter.getId(), voter);
		} else {
			throw new RuntimeException("Voter alreday exists. Voilation of Unique keys");
		}
	}

	@Override
	public void updateVoter(Voter voter) {
		voterMap.put(voter.getId(), voter);
	}

	@Override
	public Voter deleteVoter(int id) {
		Voter voter = null;
		if (voterMap.containsKey(id)) {
			voter = voterMap.get(id);
			voterMap.remove(id);
			return voter;
		}
		throw new RuntimeException("Voter not found for the id: " + id);
	}

}
