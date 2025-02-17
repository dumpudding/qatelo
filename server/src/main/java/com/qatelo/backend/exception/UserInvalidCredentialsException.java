package com.qatelo.backend.exception;

import java.io.Serial;

public class UserInvalidCredentialsException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 2L;

	public UserInvalidCredentialsException(String message) {
		super(message);
	}
}
