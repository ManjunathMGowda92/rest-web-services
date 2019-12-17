package org.manjunath.voterservice.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/info")
public class InfoController {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testController() {
		return "Welcome to Voter WebServices provider";
	}
}
