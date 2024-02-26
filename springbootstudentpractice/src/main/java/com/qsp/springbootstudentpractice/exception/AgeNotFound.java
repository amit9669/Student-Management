package com.qsp.springbootstudentpractice.exception;

public class AgeNotFound extends RuntimeException
{
	String message ;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message ;
	}
	public AgeNotFound(String message) {
		super();
		this.message = message;
	}
	
}
