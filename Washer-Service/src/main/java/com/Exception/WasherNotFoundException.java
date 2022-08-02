package com.Exception;

public class WasherNotFoundException extends RuntimeException {

	public WasherNotFoundException() {
		super();

	}

	public WasherNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public WasherNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public WasherNotFoundException(String message) {
		super(message);

	}

	public WasherNotFoundException(Throwable cause) {
		super(cause);

	}

}

