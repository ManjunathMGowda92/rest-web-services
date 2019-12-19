package org.manjunath.voterservice.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.manjunath.voterservice.model.ApiInfoModel;
import org.manjunath.voterservice.model.EndpointsDescription;

@Path("/info")
public class InfoController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response testController() {
		
		ApiInfoModel infoModel = new ApiInfoModel();
		infoModel.set_service_name("voter-rest-service");
		infoModel.set_version("1.0.0");
		infoModel.set_message("Welcome to Voter API WebServices provider");
		infoModel.set_usage("Demonstration of REST webservice api end points, where Voter is used as a Model class");
		infoModel.set_endpoints(new EndpointsDescription[] {
			new EndpointsDescription("@GET", "/voters", "To fetch list of all Voters"),
			new EndpointsDescription("@GET", "/voters/{id}", "To fetch particular Voter based on the id"),
			new EndpointsDescription("@POST", "/voters", "To save a new Voter"),
			new EndpointsDescription("@PUT", "/voters/{id}", "To update an existing Voter based on the id"),
			new EndpointsDescription("@DELETE", "/voters/{id}", "To delete an existing Voter based on the id")
		});
		
		return Response.status(Response.Status.OK)
				.entity(infoModel)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}
