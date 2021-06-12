package com.tildev.myspringboot.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 989336559419400338L;

	private int status;
	private String statusCode;
	private String description;

	public CustomException() {
		super();
	}

	public CustomException(ErrorCodeEnum errorCodeEnum) {
		super();
		this.status = errorCodeEnum.getStatus();
		this.statusCode = errorCodeEnum.getStatusCode();
		this.description = errorCodeEnum.getDescription();
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
