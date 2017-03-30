package br.com.exercise2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Address is not valid.")
public class InvalidAddress extends Exception  {
    
	public InvalidAddress() {}

	public InvalidAddress(String message)
	{
		super(message);
	}
}
