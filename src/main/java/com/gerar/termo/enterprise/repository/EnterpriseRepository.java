package com.gerar.termo.enterprise.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerar.termo.enterprise.model.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, UUID>{
	
	boolean existsByCnpj(String cnpj);

}
