package br.com.exercise1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Address Not found.")
@ResponseBody()
public class AddressNotFound extends Exception  {
    
	public AddressNotFound() {}

	public AddressNotFound(String message)
	{
		super(message);
	}
}
