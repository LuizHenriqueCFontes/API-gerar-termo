package com.gerar.termo.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gerar.termo.documentgenerate.exception.DocumentGenerationException;
import com.gerar.termo.enterprise.exception.CompanyAlreadyRegistered;
import com.gerar.termo.enterprise.exception.EnterpriseNotFoundException;
import com.gerar.termo.exception.dto.ErrorResponseDTO;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(CompanyAlreadyRegistered.class)
	public ResponseEntity<ErrorResponseDTO> handlerCompanyAlreadyRegistered(CompanyAlreadyRegistered ex) {
		ErrorResponseDTO error = new ErrorResponseDTO(LocalDateTime.now(), HttpStatus.CONFLICT.value(), "Empresa já cadastrada", 
				ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	@ExceptionHandler(EnterpriseNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handlerEnterpriseNotFoundException(EnterpriseNotFoundException ex) {
		ErrorResponseDTO error = new ErrorResponseDTO(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Empresa não encontrada", 
				ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	
	@ExceptionHandler(DocumentGenerationException.class)
	public ResponseEntity<ErrorResponseDTO> handlerDocumentGenerationException(DocumentGenerationException ex) {
		ErrorResponseDTO error = new ErrorResponseDTO(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), 
				"Falha ao gerar documento", ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

}
