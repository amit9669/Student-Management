package com.qsp.springbootstudentpractice.exception;

public class AddressNotFound extends RuntimeException
{
	String message ;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message ;
	}
	public AddressNotFound(String message) {
		super();
		this.message = message;
	}
	
}
