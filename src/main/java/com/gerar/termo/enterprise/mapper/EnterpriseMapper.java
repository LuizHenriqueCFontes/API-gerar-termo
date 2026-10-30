package com.gerar.termo.enterprise.mapper;

import org.mapstruct.Mapper;

import com.gerar.termo.enterprise.dto.response.CreateEnterpriseResponseDTO;
import com.gerar.termo.enterprise.dto.response.EditEnterpriseResponseDTO;
import com.gerar.termo.enterprise.dto.response.ListEnterpriseResponseDTO;
import com.gerar.termo.enterprise.model.Enterprise;

@Mapper(componentModel = "spring")
public interface EnterpriseMapper {
	
	public CreateEnterpriseResponseDTO toCreateEnterpriseResponseDTO(Enterprise enterprise);
	
	public EditEnterpriseResponseDTO toEditEnterpriseResponseDTO(Enterprise enterprise);
	
	public ListEnterpriseResponseDTO toListEnterpriseResponseDTO(Enterprise enterprise);

}
