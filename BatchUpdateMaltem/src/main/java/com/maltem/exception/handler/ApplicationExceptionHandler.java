package com.maltem.exception.handler;

import java.util.Date;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.maltem.exception.ApplicationException;
import com.maltem.model.ResponseDetailMessage;



@ControllerAdvice(basePackages = "com.maltem")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApplicationExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResponseDetailMessage handleMethodArgumentNotValid( ApplicationException ex) {
		ResponseDetailMessage responseDetailMessage= new ResponseDetailMessage();
		responseDetailMessage.setStatus("Failure with exception: "+ex.getMessage());
		responseDetailMessage.setTimeStamp(new Date().getTime());
		return responseDetailMessage;
	}

}
