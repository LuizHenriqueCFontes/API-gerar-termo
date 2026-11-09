package com.gerar.termo.enterprise.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateEnterpriseRequestDTO(
		
		@NotBlank
		String legalName, 
		
		@NotBlank
		String cnpj, 
		
		@NotBlank
		String address,
		
		@NotBlank
		String cep, 
		
		@NotBlank
		String city,
		
		@NotBlank
		String state) {

}
