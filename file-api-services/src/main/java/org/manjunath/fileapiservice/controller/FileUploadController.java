package org.manjunath.fileapiservice.controller;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.manjunath.fileapiservice.service.FileUploadService;
import org.manjunath.fileapiservice.service.FileUploadServiceImpl;

@Path("/fileupload")
public class FileUploadController {
	private FileUploadService service;

	public FileUploadController() {
		service = new FileUploadServiceImpl();
	}

	@POST
	@Path("/pdf")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadPdfFile(@FormDataParam("pdfFile") InputStream fileInputStream,
			@FormDataParam("pdfFile") FormDataContentDisposition fileMetaData) {

		String fileName = fileMetaData.getFileName();
		if (!fileName.endsWith(".pdf")) {
			return Response.status(Response.Status.NOT_ACCEPTABLE)
					.entity(getFileNotOfRequiredType(fileName, fileName.substring(fileName.lastIndexOf(".")), ".pdf"))
					.type(MediaType.APPLICATION_JSON)
					.build();
		}

		service.saveFilesToTarget(fileInputStream, fileMetaData);

		return Response.status(Response.Status.OK)
				.entity(getUploadSuccessMsg(fileName))
				.type(MediaType.APPLICATION_JSON)
				.build();

	}
	
	@POST
	@Path("/images")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadImageFile(@FormDataParam("imgFile") InputStream fileInputStream,
			@FormDataParam("imgFile") FormDataContentDisposition fileMetaData) {

		String fileName = fileMetaData.getFileName();
		if (!fileName.endsWith(".png") && !fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg")) {
			return Response.status(Response.Status.NOT_ACCEPTABLE)
					.entity(getFileNotOfRequiredType(fileName, fileName.substring(fileName.lastIndexOf(".")), ".png | .jpg | .jpeg"))
					.type(MediaType.APPLICATION_JSON)
					.build();
		}

		service.saveFilesToTarget(fileInputStream, fileMetaData);

		return Response.status(Response.Status.OK)
				.entity(getUploadSuccessMsg(fileName))
				.type(MediaType.APPLICATION_JSON)
				.build();

	}
	
	@POST
	@Path("/doc")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadDocFile(@FormDataParam("docFile") InputStream fileInputStream,
			@FormDataParam("docFile") FormDataContentDisposition fileMetaData) {

		String fileName = fileMetaData.getFileName();
		if (!fileName.endsWith(".doc") && !fileName.endsWith(".docx")) {
			return Response.status(Response.Status.NOT_ACCEPTABLE)
					.entity(getFileNotOfRequiredType(fileName, fileName.substring(fileName.lastIndexOf(".")), ".doc | .docx"))
					.type(MediaType.APPLICATION_JSON)
					.build();
		}

		service.saveFilesToTarget(fileInputStream, fileMetaData);

		return Response.status(Response.Status.OK)
				.entity(getUploadSuccessMsg(fileName))
				.type(MediaType.APPLICATION_JSON)
				.build();

	}
	
	@POST
	@Path("/excel")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadExcelFile(@FormDataParam("excelFile") InputStream fileInputStream,
			@FormDataParam("excelFile") FormDataContentDisposition fileMetaData) {

		String fileName = fileMetaData.getFileName();
		if (!fileName.endsWith(".xls") && !fileName.endsWith(".xlsx")) {
			return Response.status(Response.Status.NOT_ACCEPTABLE)
					.entity(getFileNotOfRequiredType(fileName, fileName.substring(fileName.lastIndexOf(".")), ".xls | .xlsx"))
					.type(MediaType.APPLICATION_JSON)
					.build();
		}

		service.saveFilesToTarget(fileInputStream, fileMetaData);

		return Response.status(Response.Status.OK)
				.entity(getUploadSuccessMsg(fileName))
				.type(MediaType.APPLICATION_JSON)
				.build();

	}

	private String getFileNotOfRequiredType(String fileName, String receivedType, String expectedType) {
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append("{")
				.append("\"_message\" : \"File uploaded is not of Required Type. Please check once\",")
				.append("\"_filename\" : \"" + fileName + "\",")
				.append("\"_received_type\" : \"" + receivedType + "\",")
				.append("\"_expected_type\" : \"" + expectedType + "\"")
				.append("}");

		return stringBuffer.toString();
	}
	
	private String getUploadSuccessMsg(String fileName) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{")
		.append("\"_message\" : \"File uploaded Successfully\",")
		.append("\"_filename\" : \"" + fileName + "\"")
		.append("}");
		
		return stringBuffer.toString();
	}
}
