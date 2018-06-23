package com.pb.response;

public class ErrorDetails {

	private String errorMessage;
	private String errorClass;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorClass() {
		return errorClass;
	}

	public void setErrorClass(String errorClass) {
		this.errorClass = errorClass;
	}

	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(String errorMessage, String errorClass) {
		super();
		this.errorMessage = errorMessage;
		this.errorClass = errorClass;
	}

}
