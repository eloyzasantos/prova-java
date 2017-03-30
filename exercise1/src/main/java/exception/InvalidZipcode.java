package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Zipcode format is incorrect.")
public class InvalidZipcode extends Exception  {
    
	public InvalidZipcode() {}

	public InvalidZipcode(String message)
	{
		super(message);
	}
}
