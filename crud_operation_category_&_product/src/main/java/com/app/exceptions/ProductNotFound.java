package com.app.exceptions;

public class ProductNotFound extends RuntimeException {
	
	public ProductNotFound(String msg)
	{
		super(msg);
	}


}