package com.gerar.termo.enterprise.service;

import org.springframework.stereotype.Service;

import com.gerar.termo.enterprise.dto.request.CreateEnterpriseRequestDTO;
import com.gerar.termo.enterprise.dto.response.CreateEnterpriseResponseDTO;
import com.gerar.termo.enterprise.exception.CompanyAlreadyRegistered;
import com.gerar.termo.enterprise.mapper.EnterpriseMapper;
import com.gerar.termo.enterprise.model.Enterprise;
import com.gerar.termo.enterprise.repository.EnterpriseRepository;

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
		
		CreateEnterpriseResponseDTO response = enterpriseMapper.toCreateEnterpriseResponseDTO(enterprise);
		
		return response;
	}
}
