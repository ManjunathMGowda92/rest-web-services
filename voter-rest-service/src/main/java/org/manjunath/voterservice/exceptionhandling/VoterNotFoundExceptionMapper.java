package org.manjunath.voterservice.exceptionhandling;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class VoterNotFoundExceptionMapper implements ExceptionMapper<VoterNotFoundException> {

	@Override
	public Response toResponse(VoterNotFoundException exception) {
		ErrorResponse response = 
				new ErrorResponse(Response.Status.NOT_FOUND.getStatusCode(),
				VoterExceptionErrorCodes.VOTER_NOT_FOUND_ERROR_CODE.getErrorCode(),
				VoterExceptionMessages.VOTER_NOT_FOUND_ERROR_MSG.getErrorMessage(), 
				exception.getMessage());

		return Response.status(Response.Status.NOT_FOUND)
				.entity(response)
				.build();
	}

}
