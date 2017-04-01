package br.com.exercise2.model;

public class ResponseError {

	public ResponseError() {
		super();
	}

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
