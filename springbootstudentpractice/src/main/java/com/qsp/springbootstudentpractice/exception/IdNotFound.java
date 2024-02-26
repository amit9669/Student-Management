package com.qsp.springbootstudentpractice.exception;

public class IdNotFound extends RuntimeException
{
	String message ;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message ;
	}
	public IdNotFound(String message) {
		super();
		this.message = message;
	}
	
}
