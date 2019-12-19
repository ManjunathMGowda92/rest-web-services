package org.manjunath.fileapiservice.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.manjunath.fileapiservice.model.ApiInfoModel;
import org.manjunath.fileapiservice.model.EndpointsDescription;

@Path("/info")
public class InfoController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response testApiService() {

		ApiInfoModel infoModel = new ApiInfoModel();
		infoModel.set_service_name("file-api-services");
		infoModel.set_version("1.0.0");
		infoModel.set_message("Welcome to File upload API services");
		infoModel.set_usage(
				"Demonstration of api end points to accept multipart form data like images, excel, pdf etc..");
		infoModel.set_endpoints(new EndpointsDescription[] {
				new EndpointsDescription("@POST", "/fileupload/pdf", "End point url to save a pdf file"),
				new EndpointsDescription("@POST", "/fileupload/images", "End point url to save images"),
				new EndpointsDescription("@POST", "/fileupload/excel", "End point url to save excel files"),
				new EndpointsDescription("@POST", "/fileupload/doc", "End point url to save word documents") });
		
		return Response.status(Response.Status.OK)
				.entity(infoModel)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}
