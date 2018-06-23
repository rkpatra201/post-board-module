package com.pb.response;

public class ServiceStatus {

	public static final ServiceStatus SUCCESS = new ServiceStatus(9101, "SUCCESS");
	public static final ServiceStatus VALIDATION_FAILED = new ServiceStatus(9102, "VALIDATION_FAILED");
	public static final ServiceStatus BAD_CREDENTIALS = new ServiceStatus(9103, "BAD_CREDENTIALS");
	public static final ServiceStatus DUPLICATE_RECORD = new ServiceStatus(9104, "DUPLICATE_RECORD_FOUND");
	public static final ServiceStatus INTERNAL_SERVER_ERROR = new ServiceStatus(9500, "INTERNAL_SERVER_ERROR");;

	private int statusCode;
	private String statusMessage;

	public ServiceStatus(int statusCode, String statusMessage) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	public ServiceStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
