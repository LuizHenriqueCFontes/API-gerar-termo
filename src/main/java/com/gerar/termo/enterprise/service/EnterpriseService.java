package com.gerar.termo.enterprise.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gerar.termo.enterprise.dto.request.CreateEnterpriseRequestDTO;
import com.gerar.termo.enterprise.dto.request.EditEnterpriseRequestDTO;
import com.gerar.termo.enterprise.dto.response.CreateEnterpriseResponseDTO;
import com.gerar.termo.enterprise.dto.response.EditEnterpriseResponseDTO;
import com.gerar.termo.enterprise.exception.CompanyAlreadyRegistered;
import com.gerar.termo.enterprise.exception.EnterpriseNotFoundException;
import com.gerar.termo.enterprise.mapper.EnterpriseMapper;
import com.gerar.termo.enterprise.model.Enterprise;
import com.gerar.termo.enterprise.repository.EnterpriseRepository;

import jakarta.transaction.Transactional;

@Service
public class EnterpriseService {
	
	private final EnterpriseRepository enterpriseRepository;
	private final EnterpriseMapper enterpriseMapper;
	
	public EnterpriseService(EnterpriseRepository enterpriseRepository, EnterpriseMapper enterpriseMapper) {
		this.enterpriseRepository = enterpriseRepository;
		this.enterpriseMapper = enterpriseMapper;
	}
 	
	public CreateEnterpriseResponseDTO createEnterprise(CreateEnterpriseRequestDTO request) {
		if(enterpriseRepository.existsByCnpj(request.cnpj())) {
			throw new CompanyAlreadyRegistered("Empresa já cadastrada");
		}
		
		Enterprise enterprise = new Enterprise();
		
		enterprise.setLegalName(request.legalName());
		enterprise.setCnpj(request.cnpj());
		enterprise.setCep(request.cep());
		enterprise.setCity(request.city());
		enterprise.setState(request.state());
		
		enterpriseRepository.save(enterprise);
		
		CreateEnterpriseResponseDTO response = enterpriseMapper.toCreateEnterpriseResponseDTO(enterprise);
		
		return response;
	}
	
	@Transactional
	public EditEnterpriseResponseDTO editEnterprise(UUID idEnterprise, EditEnterpriseRequestDTO request) {
		
		Enterprise enterprise = enterpriseRepository.findById(idEnterprise)
													.orElseThrow(() -> new EnterpriseNotFoundException("Empresa não encontrada"));
		
		if(request.legalName() != null && !request.legalName().isBlank()) {
			enterprise.setLegalName(request.legalName());
		}
		
		if(request.cnpj() != null && !request.cnpj().isBlank()) {
			enterprise.setCnpj(request.cnpj());
		}
		
		if(request.cep() != null && !request.cep().isBlank()) {
			enterprise.setCep(request.cep());
		}
		
		if(request.city() != null && !request.city().isBlank()) {
			enterprise.setCity(request.city());
		}
		
		if(request.state() != null && !request.state().isBlank()) {
			enterprise.setState(request.state());
		}
		
		enterpriseRepository.save(enterprise);
		
		EditEnterpriseResponseDTO response = enterpriseMapper.toEditEnterpriseResponseDTO(enterprise);
		
		return response;
	}
}
