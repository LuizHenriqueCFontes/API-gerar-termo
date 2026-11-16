package com.gerar.termo.termgenerate.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.gerar.termo.documentgenerate.service.DocumentGenerateService;
import com.gerar.termo.enterprise.exception.EnterpriseNotFoundException;
import com.gerar.termo.enterprise.model.Enterprise;
import com.gerar.termo.enterprise.repository.EnterpriseRepository;
import com.gerar.termo.termgenerate.dto.GenerateTermRequestDTO;
import com.gerar.termo.termgenerate.dto.TermDocumentDataDTO;

@Service
public class TermGenerateService {
	
	private final EnterpriseRepository enterpriseRepository;
	private final DocumentGenerateService documentGenerateService;
	
	public TermGenerateService(EnterpriseRepository enterpriseRepository, DocumentGenerateService documentGenerateService) {
		this.enterpriseRepository = enterpriseRepository;
		this.documentGenerateService = documentGenerateService;
	}
	
	public byte[] generateTerm(GenerateTermRequestDTO request) {
		Enterprise enterprise = enterpriseRepository.findById(request.idEnterprise())
											.orElseThrow(() -> new EnterpriseNotFoundException("Empresa não encontrada"));
		
		String generationDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		TermDocumentDataDTO data = new TermDocumentDataDTO(request.employe().name(), request.employe().cpf(), 
				request.employe().address(), enterprise.getLegalName(), enterprise.getCnpj(), 
				enterprise.getAddress(), enterprise.getCep(), enterprise.getCity(), 
				enterprise.getState(), request.equipment().notebookModel(), 
				request.equipment().notebookCharger(), generationDate);
		
		byte[] document = documentGenerateService.generateDocument(data);
		
		return document;
	}
 
}
