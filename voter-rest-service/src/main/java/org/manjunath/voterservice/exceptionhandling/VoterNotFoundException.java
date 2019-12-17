package org.manjunath.voterservice.exceptionhandling;

public class VoterNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7260578179303505581L;
	
	public VoterNotFoundException(String message) {
		super(message);
	}
}
