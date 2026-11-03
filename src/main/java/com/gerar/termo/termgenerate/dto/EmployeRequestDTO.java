package com.gerar.termo.termgenerate.dto;

import jakarta.validation.constraints.NotBlank;

public record EmployeRequestDTO(
		
		@NotBlank
		String name, 
		
		@NotBlank
		String cpf, 
		
		@NotBlank
		String address) {

}
