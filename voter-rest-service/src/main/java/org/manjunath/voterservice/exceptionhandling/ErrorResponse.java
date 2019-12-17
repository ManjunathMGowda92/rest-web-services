package org.manjunath.voterservice.exceptionhandling;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -161721815136453783L;

	private int errorCode;
	private String customErrorCode;
	private String customErrorMessage;
	private String errorMessage;
		

	public ErrorResponse() {
	}

	/**
	 * Parameterized Constructor
	 * @param errorCode
	 * @param customErrorCode
	 * @param customErrorMessage
	 * @param errorMessage
	 * @param status
	 */
	public ErrorResponse(int errorCode, String customErrorCode, String customErrorMessage, String errorMessage) {
		this.errorCode = errorCode;
		this.customErrorCode = customErrorCode;
		this.customErrorMessage = customErrorMessage;
		this.errorMessage = errorMessage;
	}



	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getCustomErrorCode() {
		return customErrorCode;
	}

	public void setCustomErrorCode(String customErrorCode) {
		this.customErrorCode = customErrorCode;
	}

	public String getCustomErrorMessage() {
		return customErrorMessage;
	}

	public void setCustomErrorMessage(String customErrorMessage) {
		this.customErrorMessage = customErrorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
