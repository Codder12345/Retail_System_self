package com.example.demo.ExceptionHandel;

public class ExceptionNotFound extends RuntimeException  {
	
	private String message;
	
	
	public ExceptionNotFound (String message)
	{
		super(message);
		this.message=message;
		
	}

}
