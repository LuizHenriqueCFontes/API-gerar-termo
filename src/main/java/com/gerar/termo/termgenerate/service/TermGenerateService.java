package com.gerar.termo.termgenerate.service;

import org.springframework.stereotype.Service;

import com.gerar.termo.enterprise.repository.EnterpriseRepository;

@Service
public class TermGenerateService {
	
	private final EnterpriseRepository enterpriseRepository;
	
	public TermGenerateService(EnterpriseRepository enterpriseRepository) {
		this.enterpriseRepository = enterpriseRepository;
	}
 
}
