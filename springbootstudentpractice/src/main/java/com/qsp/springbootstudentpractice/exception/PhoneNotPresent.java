package com.qsp.springbootstudentpractice.exception;

public class PhoneNotPresent extends RuntimeException
{
	String message ;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message ;
	}
	public PhoneNotPresent(String message) {
		super();
		this.message = message;
	}
	
}
