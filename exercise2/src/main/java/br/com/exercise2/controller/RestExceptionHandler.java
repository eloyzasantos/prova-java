package br.com.exercise2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.exercise2.exception.AddressNotFound;
import br.com.exercise2.exception.InvalidAddress;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(value = { InvalidAddress.class })
    @ResponseBody
    protected ResponseEntity<Error> handleInvalidAddress() {
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error("Invalid Address"));
    }
    
    @ExceptionHandler(value = { AddressNotFound.class })
    @ResponseBody
    protected ResponseEntity<Error> handleAddressNotFound() {
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error("Address not found for this code"));
    }
}
