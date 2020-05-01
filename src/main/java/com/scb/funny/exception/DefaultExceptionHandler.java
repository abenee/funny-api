package com.scb.funny.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.scb.funny.bean.ErrorMessage;


@ControllerAdvice
@RestController
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorMessage error = new ErrorMessage(new Date(), "500", ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ServiceException.class)
    public final ResponseEntity<Object> badRequestException(Exception ex, WebRequest request) {
        ErrorMessage error = new ErrorMessage(new Date(), "400", ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}


