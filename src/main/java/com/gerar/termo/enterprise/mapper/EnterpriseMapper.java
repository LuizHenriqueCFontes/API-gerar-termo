package com.gerar.termo.enterprise.mapper;

import org.mapstruct.Mapper;

import com.gerar.termo.enterprise.dto.response.CreateEnterpriseResponseDTO;
import com.gerar.termo.enterprise.model.Enterprise;

@Mapper(componentModel = "spring")
public interface EnterpriseMapper {
	
	public CreateEnterpriseResponseDTO toCreateEnterpriseResponseDTO(Enterprise enterprise);

}
