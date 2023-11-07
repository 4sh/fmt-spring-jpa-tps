package com.qsh.learning.springRestJpa.core.handlers;

import com.qsh.learning.springRestJpa.car.exceptions.CarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {CarNotFoundException.class})
	protected ResponseEntity<String> handleException(CarNotFoundException e) {
		logger.error(e.getMessage(), e);

		return new ResponseEntity<>("Car not found", HttpStatus.NOT_FOUND);
	}
}
