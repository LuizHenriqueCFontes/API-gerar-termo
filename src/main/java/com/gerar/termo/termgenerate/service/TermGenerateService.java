package com.gerar.termo.termgenerate.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.gerar.termo.enterprise.exception.EnterpriseNotFoundException;
import com.gerar.termo.enterprise.model.Enterprise;
import com.gerar.termo.enterprise.repository.EnterpriseRepository;
import com.gerar.termo.termgenerate.dto.GenerateTermRequestDTO;
import com.gerar.termo.termgenerate.dto.TermDocumentDataDTO;

@Service
public class TermGenerateService {
	
	private final EnterpriseRepository enterpriseRepository;
	
	public TermGenerateService(EnterpriseRepository enterpriseRepository) {
		this.enterpriseRepository = enterpriseRepository;
	}
	
	public byte[] generateTerm(GenerateTermRequestDTO request) {
		Enterprise enterprise = enterpriseRepository.findById(request.idEnterprise())
											.orElseThrow(() -> new EnterpriseNotFoundException("Empresa não encontrada"));
		
		TermDocumentDataDTO data = new TermDocumentDataDTO(request.employe().name(), request.employe().cpf(), 
				request.employe().address(), enterprise.getLegalName(), enterprise.getAddress(), 
				enterprise.getCnpj(), enterprise.getCep(), enterprise.getCity(), 
				enterprise.getState(), request.equipment().notebookModel(), 
				request.equipment().notebookCharger(), LocalDate.now());
		
	}
 
}
