package com.algaworks.brewer.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.brewer.service.Exception.NomeEstiloJaCadastradoException;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<String> handlerNomeEstiloJaCadastradoException(NomeEstiloJaCadastradoException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}
