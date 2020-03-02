package com.allesion.products.exception;

public class ProductNotFoundException extends Exception{

	private String messsage;
	
	public ProductNotFoundException(String message){
		super(message);
	}
	
}
