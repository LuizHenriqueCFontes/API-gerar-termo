package com.gerar.termo.enterprise.dto.response;

import java.util.UUID;

public record DetailsEnterpriseResponseDTO(UUID idEnterprise, String legalName, String cnpj, String address, String cep, 
		String city, String state) {

}
