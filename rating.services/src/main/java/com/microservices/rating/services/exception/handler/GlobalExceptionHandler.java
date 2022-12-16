package com.microservices.rating.services.exception.handler;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microservices.rating.services.exception.EntityNotFoundException;
import com.microservices.rating.services.exception.handler.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Autowired
	MessageSource messageSource;
	
	/**
	 * Handles {@code EntityNotFoundException}.
	 * 
	 * <p>
	 * 	This exception handler is triggered when an {@link com.bear.dispenser.apis.exception.EntityNotFoundException EntityNotFoundException} is thrown.
	 * </p>
	 * 
	 * @param 	e
	 * 			Instance of {@code EntityNotFoundException}
	 * 
	 * @return	List of parameters defined in {@code ErrorResponse} as API response along with a HTTP status code
	 */
	@ExceptionHandler({EntityNotFoundException.class})
	public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException e){
		String errorMessage = messageSource.getMessage(e.getMessage(), null, Locale.ENGLISH);
		List<String> errorParameters = e.getErrorParameters();
		
		if(!CollectionUtils.isEmpty(errorParameters)) {
			errorMessage = String.format(errorMessage, errorParameters.toArray());
		}
		
		ErrorResponse errorResponse  = ErrorResponse.builder()
													.errorMessage(errorMessage)
													.build();
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
}
