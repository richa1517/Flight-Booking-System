package com.capg.exceptions;

public class PassengerAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PassengerAlreadyExistsException() {

	}

	public PassengerAlreadyExistsException(String message) {
		super(message);
	}
}
