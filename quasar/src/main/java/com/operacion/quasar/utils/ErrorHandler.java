package com.operacion.quasar.utils;

public class ErrorHandler extends RuntimeException {
	public ErrorHandler(String errorMessage) {
		super(errorMessage);
	}
	
	public ErrorHandler(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}
