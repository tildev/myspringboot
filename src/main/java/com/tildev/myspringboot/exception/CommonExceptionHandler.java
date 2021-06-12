package com.tildev.myspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tildev.myspringboot.vo.ResponseHeaderVo;
import com.tildev.myspringboot.vo.ResponseVo;

@ControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<ResponseVo> handleMissingServletRequestParameterException(Exception e) {

		ResponseVo response = new ResponseVo();

		ResponseHeaderVo responseHeaderVo = new ResponseHeaderVo();

		responseHeaderVo.setStatus(ErrorCodeEnum.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION.getStatus());
		responseHeaderVo.setStatusCode(ErrorCodeEnum.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION.getStatusCode());
		responseHeaderVo.setDescription(ErrorCodeEnum.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION.getDescription());

		response.setHeaderVo(responseHeaderVo);

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<ResponseVo> handleBindException(BindException e) {

		ResponseVo response = new ResponseVo();

		ResponseHeaderVo responseHeaderVo = new ResponseHeaderVo();

		e.getFieldError("name");
		FieldError fieldError = e.getFieldError();

		response.setHeaderVo(responseHeaderVo);

		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ResponseVo> handleCustomException(CustomException e) {

		ResponseVo response = new ResponseVo();

		ResponseHeaderVo responseHeaderVo = new ResponseHeaderVo();

		responseHeaderVo.setStatus(e.getStatus());
		responseHeaderVo.setStatusCode(e.getStatusCode());
		responseHeaderVo.setDescription(e.getDescription());

		response.setHeaderVo(responseHeaderVo);

		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseVo> handleException(Exception e) {

		ResponseVo response = new ResponseVo();

		ResponseHeaderVo responseHeaderVo = new ResponseHeaderVo();

		responseHeaderVo.setStatus(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getStatus());
		responseHeaderVo.setStatusCode(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getStatusCode());
		responseHeaderVo.setDescription(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getDescription());

		response.setHeaderVo(responseHeaderVo);

		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
