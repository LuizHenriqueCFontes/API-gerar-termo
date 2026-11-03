package com.gerar.termo.termgenerate.dto;

import java.util.UUID;

public record GenerateTermRequestDTO(UUID idEnterprise, EmployeRequestDTO employe, EquipmentRequestDTO equipment) {

}
