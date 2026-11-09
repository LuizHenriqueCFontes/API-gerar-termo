package com.gerar.termo.enterprise.dto.response;

import java.util.UUID;

public record ListEnterpriseResponseDTO(UUID idEnterprise, String legalName, String cnpj, String address, String cep, String city, String state) {

}
