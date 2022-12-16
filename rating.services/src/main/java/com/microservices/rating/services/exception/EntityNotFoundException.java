package com.microservices.rating.services.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8189334409219032404L;
	
	private List<String> errorParameters;

	public EntityNotFoundException() {
		super();
	}
	
	/**
	 * Throws EntityNotFoundException with an error message.
	 * 
	 * @param 	errorMessage
	 * 			Error message to be shown to user when this exception is thrown.
	 * 
	 * @param   errorParameters
	 * 			Error parameters contain data which is required in user-facing error messages to provide user more 
	 *          meaningful error messages like name, id etc.      
	 */
	public EntityNotFoundException(String errorMessage, List<String> errorParameters) {
		super(errorMessage);
		this.errorParameters = errorParameters;

	}
}
