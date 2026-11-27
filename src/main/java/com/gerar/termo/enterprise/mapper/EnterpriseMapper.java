package com.gerar.termo.enterprise.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.gerar.termo.enterprise.dto.response.CreateEnterpriseResponseDTO;
import com.gerar.termo.enterprise.dto.response.DetailsEnterpriseResponseDTO;
import com.gerar.termo.enterprise.dto.response.EditEnterpriseResponseDTO;
import com.gerar.termo.enterprise.dto.response.ListEnterpriseResponseDTO;
import com.gerar.termo.enterprise.dto.response.PageListEnterpriseResponseDTO;
import com.gerar.termo.enterprise.model.Enterprise;

@Mapper(componentModel = "spring")
public interface EnterpriseMapper {
	
	public CreateEnterpriseResponseDTO toCreateEnterpriseResponseDTO(Enterprise enterprise);
	
	public EditEnterpriseResponseDTO toEditEnterpriseResponseDTO(Enterprise enterprise);
	
	public PageListEnterpriseResponseDTO toListPageEnterpriseResponseDTO(Enterprise enterprise);
	
	public List<ListEnterpriseResponseDTO> toListEnterpriseResponseDTO(List<Enterprise> enterprise);
	
	public DetailsEnterpriseResponseDTO toDetailsEnterpriseResponseDTO(Enterprise enterprise);

}
