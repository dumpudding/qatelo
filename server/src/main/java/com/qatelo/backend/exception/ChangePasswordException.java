package com.qatelo.backend.exception;

import java.io.Serial;

public class ChangePasswordException extends RuntimeException {
	@Serial
	private static final long serialVersionUID = 3L;

	public ChangePasswordException(String message) {
		super(message);
	}
}
