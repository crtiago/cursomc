package com.tiago.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tiago.cursomc.services.execeptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	/*
	 * Implementando uma classe auxiliar que vai interceptar as exceções,e obrigatoriamente dentro do framework ela tem
	 * que ter essa assinatura
	 */

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

	}
}
