package org.manjunath.voterservice.exceptionhandling;

public enum VoterExceptionErrorCodes {
	VOTER_NOT_FOUND_ERROR_CODE("VOTER_101"),
	GENERIC_ERROR_CODE("VOTER_001");
	
	private String errorCode;
	
	VoterExceptionErrorCodes(String errorCode){
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
