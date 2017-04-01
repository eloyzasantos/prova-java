package br.com.exercise1.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.exercise1.exception.AddressNotFound;
import br.com.exercise1.exception.InvalidZipcode;
import br.com.exercise1.model.ResponseError;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(value = { InvalidZipcode.class })
    @ResponseBody
    protected ResponseEntity<ResponseError> handleInvalidZipcode(HttpServletResponse response) {
    	return new ResponseEntity<ResponseError>(new ResponseError("Invalid zipcode."), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(value = { AddressNotFound.class })
    @ResponseBody
    public ResponseEntity<ResponseError> handleAddressNotFound() {
    	return new ResponseEntity<ResponseError>(new ResponseError("Address not found for this zipcode"), HttpStatus.NOT_FOUND);
    }
    
}
