package com.gerar.termo.termgenerate.dto;

import java.time.LocalDate;

public record TermDocumentDataDTO(
		String employeName,
	    String employeCpf,
	    String employeAddress,

	    String enterpriseLegalName,
	    String enterpriseCnpj,
	    String enterpriseAddress,
	    String enterpriseCep,
	    String enterpriseCity,
	    String enterpriseState,

	    String notebookModel,
	    String notebookCharger,

	    LocalDate generationDate
		
		
		) {

}
