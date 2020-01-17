package mx.com.gnp.plus.consultasinies.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;
import mx.com.gnp.plus.consultasinies.Application;
import mx.com.gnp.plus.consultasinies.exception.*;
import org.springframework.http.HttpStatus;

/**
 * @author jsetien
 *
 */
@RestControllerAdvice
@Slf4j
public class HttpExceptionHandler {
	public static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HttpExceptionHandler.class);

	/**
	 * Maneja la excepción RuntimeException que se lanza al mandar.
	 * saludos a un nombre inválido
	 */
	@ResponseStatus(value =org.springframework.http.HttpStatus.BAD_REQUEST, 
			reason = "Invalid name")
	@ExceptionHandler(InvalidNameException.class)
	public final void badRequestDuplicatedRecipients(ExceptionEot e) {
		String mensaje;
		HttpStatus code;
		ResponseStatusException respuesta; 
		mensaje=e.getMessage();
		code=e.getResponseCode();
		throw new ResponseStatusException(code);
	}
}
