package org.manjunath.voterservice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.manjunath.voterservice.exceptionhandling.VoterNotFoundException;
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
		Voter voter = null;
		try {
			voter = voterMap.entrySet().stream().filter(entry -> entry.getKey() == id).findFirst().get().getValue();
		} catch (NoSuchElementException e) {
			throw new VoterNotFoundException("Voter not found for the id: " + id);
		}

		return voter;
	}

	@Override
	public Voter addVoter(Voter voter) {
		if (!voterMap.containsKey(voter.getId())) {
			return voterMap.put(voter.getId(), voter);
		}
		throw new RuntimeException("Voter alreday exists. Voilation of Unique keys");
	}

	@Override
	public Voter updateVoter(Voter voter) {
		return voterMap.put(voter.getId(), voter);
	}

	@Override
	public Voter deleteVoter(int id) {
		Voter voter = null;
		if (voterMap.containsKey(id)) {
			voter = voterMap.get(id);
			voterMap.remove(id);
			return voter;
		}
		throw new VoterNotFoundException("Voter not found for the id: " + id);
	}

}
