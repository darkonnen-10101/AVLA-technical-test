package com.darkonnen.test.exception;

public class EntityNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 4315164310315034893L;
	
	public EntityNotFoundException(String message) {
		super(message);
	}

}
