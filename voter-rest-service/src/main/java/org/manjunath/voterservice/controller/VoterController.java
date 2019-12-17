package org.manjunath.voterservice.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/voters")
public class VoterController {
	
	@GET
	@Path("/welcome")
	public String testController() {
		return "Welcome to Voter WebServices provider";
	}
}
