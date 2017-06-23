/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travix.medusa.busyflights.Exception;

/**
 *
 * @author temitokut
 */
public class RestException extends RuntimeException {
    
     public RestException() {
        super();
    }

    public RestException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestException(String message) {
        super(message);
    }

    public RestException(Throwable cause) {
        super(cause);
    }
    
}
