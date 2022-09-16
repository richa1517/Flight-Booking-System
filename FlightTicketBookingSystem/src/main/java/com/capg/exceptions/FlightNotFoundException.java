package com.capg.exceptions;

public class FlightNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public FlightNotFoundException() {
		
	}
	
	public FlightNotFoundException(String message) {
		super(message);
	}
	
}
