package com.allesion.products.exception;


/**
 * The Class ProductNotFoundException.
 */
public class ProductNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1580613418867142827L;
	/**
	 * Instantiates a new product not found exception.
	 *
	 * @param message the message
	 */
	public ProductNotFoundException(String message){
		super(message);
	}
	
}
