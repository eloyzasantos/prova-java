package br.com.exercise1.model;

public class ResponseError {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseError(String message) {
		super();
		this.message = message;
	}
	
	
}
