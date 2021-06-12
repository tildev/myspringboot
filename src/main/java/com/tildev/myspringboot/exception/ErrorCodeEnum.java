package com.tildev.myspringboot.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCodeEnum {

	// Common Exception
	MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION(HttpStatus.BAD_REQUEST.value(), "C401",
			"Missing Servlet request parameter exception"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "C501", "Internal server error"),

	// Business Exception
	;

	private final int status;
	private final String statusCode;
	private final String description;

	private ErrorCodeEnum(int status, String statusCode, String description) {
		this.status = status;
		this.statusCode = statusCode;
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getDescription() {
		return description;
	}
}
