/**
 * 
 */
package com.ericsson.erifly.security.service;

/**
 * @author Dhrubo
 *
 */
public class UserNotFoundException extends RuntimeException{

   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public UserNotFoundException(String message) {
        super(message);   
    }

    
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);    
    }

   
    public UserNotFoundException(Throwable cause) {
        super(cause);    
    }
}
