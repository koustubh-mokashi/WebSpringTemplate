package com.template.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 */
	private static final long serialVersionUID = -8282603053132555801L;

	public UserNotFoundException(int userId) {
		super("User for userId '" + userId +"' not found");
	}
}
