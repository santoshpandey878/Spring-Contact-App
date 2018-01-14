package com.youtube.exception;

public class UserBlockedException extends Exception{
	
	// create user object without error description
	public UserBlockedException(){
		
	}
	// create user object with error description
	public UserBlockedException(String errDesc){
		super(errDesc);
	}

}
