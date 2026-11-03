package com.gerar.termo.enterprise.exception;

public class CompanyAlreadyRegistered extends RuntimeException {
	
	public CompanyAlreadyRegistered(String message) {
		super(message);
	}
	
	public CompanyAlreadyRegistered(String message, Throwable cause) {
		super(message, cause);
	}

}
