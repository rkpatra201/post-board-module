package com.pb.response;

public class WmResponse {

	ServiceStatus serviceStatus;
	ErrorDetails errorDetails;
	ValidationErrors validationErrors;
	Object[] data;

	public ServiceStatus getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(ServiceStatus serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public ErrorDetails getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(ErrorDetails errorDetails) {
		this.errorDetails = errorDetails;
	}

	public ValidationErrors getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(ValidationErrors validationErrors) {
		this.validationErrors = validationErrors;
	}

	public Object[] getData() {
		return data;
	}

	public void setData(Object[] data) {
		this.data = data;
	}

	public WmResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WmResponse(ServiceStatus serviceStatus, ErrorDetails errorDetails, ValidationErrors validationErrors,
			Object[] data) {
		super();
		this.serviceStatus = serviceStatus;
		this.errorDetails = errorDetails;
		this.validationErrors = validationErrors;
		this.data = data;
	}

	@Override
	public String toString() {
		return "AhloResponse [serviceStatus=" + serviceStatus + ", errorDetails=" + errorDetails + ", validationErrors="
				+ validationErrors + ", data=" + data + "]";
	}
	
	
}
