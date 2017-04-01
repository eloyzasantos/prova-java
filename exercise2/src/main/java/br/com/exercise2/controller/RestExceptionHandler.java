package br.com.exercise2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import br.com.exercise2.exception.AddressNotFound;
import br.com.exercise2.exception.InvalidAddress;
import br.com.exercise2.exception.InvalidZipcode;
import br.com.exercise2.model.ResponseError;

@ControllerAdvice
public class RestExceptionHandler extends DefaultHandlerExceptionResolver  {
 
	@ExceptionHandler(value = { InvalidZipcode.class })
	public ResponseEntity<ResponseError> handleInvalidZipcode() {
		return new ResponseEntity<ResponseError>(new ResponseError("Invalid Zipcode."), HttpStatus.BAD_REQUEST);
	}
	
    @ExceptionHandler(value = { InvalidAddress.class })
    public ResponseEntity<ResponseError> handleInvalidAddress() {
    	return new ResponseEntity<ResponseError>(new ResponseError("Invalid Address."), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(value = { AddressNotFound.class })
    @ResponseBody
    public ResponseEntity<ResponseError> handleAddressNotFound() {
    	return new ResponseEntity<ResponseError>(new ResponseError("Address not found for this code."), HttpStatus.NOT_FOUND);
    }
}
