package br.com.exercise1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.exercise1.exception.AddressNotFound;
import br.com.exercise1.exception.InvalidZipcode;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(value = { InvalidZipcode.class })
    @ResponseBody
    protected ResponseEntity<Error> handleInvalidZipcode() {
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error("Invalid Zipcode."));
    }
    
    @ExceptionHandler(value = { AddressNotFound.class })
    @ResponseBody
    protected ResponseEntity<Error> handleAddressNotFound() {
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error("Address not found for this zipcode"));
    }
}
