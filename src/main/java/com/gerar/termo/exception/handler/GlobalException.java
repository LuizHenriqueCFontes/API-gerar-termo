package com.gerar.termo.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gerar.termo.enterprise.exception.CompanyAlreadyRegistered;
import com.gerar.termo.exception.dto.ErrorResponseDTO;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(CompanyAlreadyRegistered.class)
	public ResponseEntity<ErrorResponseDTO> handlerCompanyAlreadyRegistered(CompanyAlreadyRegistered ex) {
		ErrorResponseDTO error = new ErrorResponseDTO(LocalDateTime.now(), HttpStatus.CONFLICT.value(), "Empresa já cadastrada", 
				ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

}
