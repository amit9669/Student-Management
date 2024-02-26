package com.qsp.springbootstudentpractice.exception;

public class NoDataAvailable extends RuntimeException {
	String message;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public NoDataAvailable(String message) {
		super();
		this.message = message;
	}

}
