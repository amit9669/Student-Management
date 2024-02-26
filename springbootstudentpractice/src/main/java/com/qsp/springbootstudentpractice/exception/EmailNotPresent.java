package com.qsp.springbootstudentpractice.exception;

public class EmailNotPresent extends RuntimeException
{
	String message ;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message ;
	}
	public EmailNotPresent(String message) {
		super();
		this.message = message;
	}
	
}
