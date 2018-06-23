package com.pb.response;

import java.util.List;

public class ValidationErrors {

	private String message;
	private List<String> validationErrors;
	public ValidationErrors(String message, List<String> validationErrors) {
		super();
		this.message = message;
		this.validationErrors = validationErrors;
	}
	public ValidationErrors() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getValidationErrors() {
		return validationErrors;
	}
	public void setValidationErrors(List<String> validationErrors) {
		this.validationErrors = validationErrors;
	}
	
}
