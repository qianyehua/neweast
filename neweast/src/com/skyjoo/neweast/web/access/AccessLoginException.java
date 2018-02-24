package com.skyjoo.neweast.web.access;

public class AccessLoginException extends RuntimeException {

	private static final long serialVersionUID = -4757581999998896852L;

	public AccessLoginException() {
		super();
	}

	public AccessLoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccessLoginException(String message) {
		super(message);
	}

	public AccessLoginException(Throwable cause) {
		super(cause);
	}

}
