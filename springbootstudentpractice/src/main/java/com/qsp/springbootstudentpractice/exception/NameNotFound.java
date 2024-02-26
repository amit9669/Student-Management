package com.qsp.springbootstudentpractice.exception;

public class NameNotFound extends RuntimeException
{
	String message ;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message ;
	}
	public NameNotFound(String message) {
		super();
		this.message = message;
	}	
}
