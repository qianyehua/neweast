package com.skyjoo.neweast.web.access;

public class AccessDeniedException extends RuntimeException {

	private static final long serialVersionUID = -4757581999998896852L;

	public AccessDeniedException() {
		super();
	}

	public AccessDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccessDeniedException(String message) {
		super(message);
	}

	public AccessDeniedException(Throwable cause) {
		super(cause);
	}

}
