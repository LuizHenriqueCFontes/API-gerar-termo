package com.gerar.termo.enterprise.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "enterprises")
@Data
public class Enterprise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_enterprise")
	private UUID idEnterprise;
	
	@Column(name = "legal_name", nullable = false)
	private String legalName; 
	
	@Column(nullable = false)
	private String cnpj;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
}
