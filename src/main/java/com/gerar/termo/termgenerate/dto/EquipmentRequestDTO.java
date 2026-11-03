package com.gerar.termo.termgenerate.dto;

import jakarta.validation.constraints.NotBlank;

public record EquipmentRequestDTO(
		
		@NotBlank
		String notebookModel, 
		
		@NotBlank
		String notebookCharger) {

}
