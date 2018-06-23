package com.pb.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseSender {

	private WmResponse buildSuccessResponse(Object[] data) {
		WmResponse wmResponse = new WmResponse();
		wmResponse.data = data;
		wmResponse.serviceStatus = ServiceStatus.SUCCESS;
		return wmResponse;
	}

	public ResponseEntity<Object> sendResponse(Object[] data) {
		return new ResponseEntity<>(buildSuccessResponse(data), HttpStatus.OK);
	}

}