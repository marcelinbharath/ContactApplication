package com.capp.exception;

public class UserBlockedException extends Exception{
	
	/*
	 * Creates user object without error description
	 */
	public UserBlockedException() {
	}
	
	/*
	 * Creates user object with error description
	 */
	public UserBlockedException(String errDesc) {
		super(errDesc);
	}
}
