package br.com.exercise2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InvalidZipcode extends Exception  {
    
	public InvalidZipcode() {}

	public InvalidZipcode(String message)
	{
		super(message);
	}
}
