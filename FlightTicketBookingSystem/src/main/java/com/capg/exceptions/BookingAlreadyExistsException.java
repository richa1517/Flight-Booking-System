package com.capg.exceptions;

public class BookingAlreadyExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public BookingAlreadyExistsException() {
		
	}
	
	public BookingAlreadyExistsException(String message) {
		super(message);
	}
	
}
