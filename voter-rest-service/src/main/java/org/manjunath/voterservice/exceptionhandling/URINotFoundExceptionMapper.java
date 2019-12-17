package org.manjunath.voterservice.exceptionhandling;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class URINotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

	@Override
	public Response toResponse(NotFoundException exception) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorCode(Response.Status.NOT_FOUND.getStatusCode());
		response.setCustomErrorCode(VoterExceptionErrorCodes.REQUESTED_URI_NOT_FOUND_ERROR_CODE.getErrorCode());
		response.setCustomErrorMessage(VoterExceptionMessages.REQUESTED_URI_NOT_FOUND_ERROR_MSG.getErrorMessage());
		response.setErrorMessage(exception.getMessage());
		
		return Response.status(Response.Status.NOT_FOUND)
				.entity(response)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
