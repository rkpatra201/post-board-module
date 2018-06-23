package com.pb.exceptions;

public class DuplicateRecordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String errorMessage;

	public DuplicateRecordException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

}
