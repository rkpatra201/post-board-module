package com.pb.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pb.response.ErrorDetails;
import com.pb.response.ServiceStatus;
import com.pb.response.ValidationErrors;
import com.pb.response.WmResponse;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	Logger LOGGER = org.slf4j.LoggerFactory.getLogger(AppExceptionHandler.class);

	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<Object> handleBadCredentialException(BadCredentialsException e) {

		doLogging(e);
		WmResponse response = new WmResponse();
		response.setServiceStatus(ServiceStatus.BAD_CREDENTIALS);
		return new ResponseEntity(response, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(DuplicateRecordException.class)
	public ResponseEntity<Object> duplicateRecordException(DuplicateRecordException e) {

		doLogging(e);
		ErrorDetails errorDetails = new ErrorDetails(e.getMessage(), e.getClass().getName());
		WmResponse response = new WmResponse();
		response.setServiceStatus(ServiceStatus.DUPLICATE_RECORD);
		response.setErrorDetails(errorDetails);
		return new ResponseEntity(response, HttpStatus.FOUND);
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<Object> duplicateRecordException(Throwable e) {
		doLogging(e);
		ErrorDetails errorDetails = new ErrorDetails(e.getMessage(), e.getClass().getName());
		WmResponse response = new WmResponse();
		response.setServiceStatus(ServiceStatus.INTERNAL_SERVER_ERROR);
		response.setErrorDetails(errorDetails);
		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		doLogging(ex);
		List<String> details = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		ValidationErrors error = new ValidationErrors("Validation Failed", details);
		WmResponse response = new WmResponse();
		response.setServiceStatus(ServiceStatus.VALIDATION_FAILED);
		response.setValidationErrors(error);
		return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
	}

	public void doLogging(Throwable e) {
		LOGGER.error(e.toString(), e);
	}

}
