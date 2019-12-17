package org.manjunath.voterservice.exceptionhandling;

public enum VoterExceptionMessages {
	VOTER_NOT_FOUND_ERROR_MSG("Unable to find the Requested Voter"),
	GENERIC_ERROR_MSG("Something went Wrong. Sorry for the inconvenience");
	
	private String errorMessage;
	
	VoterExceptionMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
