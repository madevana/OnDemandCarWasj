package com.exception;

public class OrderAlreadyExistException extends RuntimeException {

	public OrderAlreadyExistException() {
		super();

	}

	public OrderAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public OrderAlreadyExistException(String message, Throwable cause) {
		super(message, cause);

	}

	public OrderAlreadyExistException(String message) {
		super(message);

	}

	public OrderAlreadyExistException(Throwable cause) {
		super(cause);

	}

}
