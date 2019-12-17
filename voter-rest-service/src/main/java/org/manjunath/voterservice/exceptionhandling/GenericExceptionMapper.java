package org.manjunath.voterservice.exceptionhandling;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable throwable) {
		ErrorResponse response = new ErrorResponse();
		response.setErrorCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		response.setCustomErrorCode(VoterExceptionErrorCodes.GENERIC_ERROR_CODE.getErrorCode());
		response.setCustomErrorMessage(VoterExceptionMessages.GENERIC_ERROR_MSG.getErrorMessage());
		response.setErrorMessage(throwable.getMessage());
		
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity(response)
				.build();
	}

}
