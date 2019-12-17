package org.manjunath.voterservice.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.manjunath.voterservice.dao.VoterDaoImpl;
import org.manjunath.voterservice.model.Voter;
import org.manjunath.voterservice.service.VoterService;
import org.manjunath.voterservice.service.VoterServiceImpl;

@Path("/voters")
public class VoterController {
	private VoterService service;

	public VoterController() {
		service = new VoterServiceImpl();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Voter> getVotersList() {
		return service.getAllVoters();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Voter getVoterById(@PathParam("id") int id){
		return service.findVoterById(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addVoter(Voter voter){
		service.addVoter(voter);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateVoter(@PathParam("id") int id, Voter voter){
		service.updateVoter(voter);
	}
}
