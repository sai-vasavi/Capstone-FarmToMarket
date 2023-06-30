/**
 * 
 */
package com.app.digitalbussiness.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.digitalbussiness.exception.NoSuchElementFoundException;

/**
 * @author BasaniVa
 *
 */
@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(value = NoSuchElementFoundException.class)
	public ResponseEntity<Object> exception(NoSuchElementFoundException exception)
	{
		return new ResponseEntity<>("Id not found", HttpStatus.NOT_FOUND);
	}

}
