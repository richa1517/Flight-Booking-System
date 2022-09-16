package com.capg.exceptions;

public class PassengerNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public PassengerNotFoundException() {
		
	}
	
	public PassengerNotFoundException(String message) {
		super(message);
	}
	
}
