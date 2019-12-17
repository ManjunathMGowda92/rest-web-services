package org.manjunath.voterservice.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	public Response getVotersList() {
		return Response.status(Response.Status.OK)
				.entity(service.getAllVoters())
				.build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVoterById(@PathParam("id") int id){
		return Response.status(Response.Status.OK)
				.entity(service.findVoterById(id))
				.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addVoter(Voter voter){
		return Response.status(Response.Status.CREATED)
				.entity(service.addVoter(voter))
				.build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateVoter(@PathParam("id") int id, Voter voter){
		return Response.status(Response.Status.CREATED)
				.entity(service.addVoter(voter))
				.build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteVoter(@PathParam("id") int id){
		return Response.status(Response.Status.OK)
				.entity(service.deleteVoterById(id))
				.build();
	}
}
