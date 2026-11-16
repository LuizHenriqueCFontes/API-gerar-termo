package com.gerar.termo.termgenerate.dto;


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

	    String generationDate
		
		
		) {

}
