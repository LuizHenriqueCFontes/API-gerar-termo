package com.gerar.termo.enterprise.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerar.termo.enterprise.dto.request.CreateEnterpriseRequestDTO;
import com.gerar.termo.enterprise.dto.request.EditEnterpriseRequestDTO;
import com.gerar.termo.enterprise.dto.response.CreateEnterpriseResponseDTO;
import com.gerar.termo.enterprise.dto.response.DetailsEnterpriseResponseDTO;
import com.gerar.termo.enterprise.dto.response.EditEnterpriseResponseDTO;
import com.gerar.termo.enterprise.dto.response.ListEnterpriseResponseDTO;
import com.gerar.termo.enterprise.dto.response.PageListEnterpriseResponseDTO;
import com.gerar.termo.enterprise.service.EnterpriseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/enterprise")
public class EnterpriseController {
	
	private final EnterpriseService enterpriseService;
	
	public EnterpriseController(EnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}
	
	@PostMapping
	public ResponseEntity<CreateEnterpriseResponseDTO> createEnterprise(@RequestBody @Valid CreateEnterpriseRequestDTO request) {
		CreateEnterpriseResponseDTO response = enterpriseService.createEnterprise(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PatchMapping("/{idEnterprise}")
	public ResponseEntity<EditEnterpriseResponseDTO> editEnterprise(@PathVariable UUID idEnterprise, @RequestBody EditEnterpriseRequestDTO request) {
		EditEnterpriseResponseDTO response = enterpriseService.editEnterprise(idEnterprise, request);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<PageListEnterpriseResponseDTO>> pageListEnterprise(Pageable pageable) {
		Page<PageListEnterpriseResponseDTO> response = enterpriseService.pageListEnterprise(pageable);
		
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<ListEnterpriseResponseDTO>> listEnterpriseResponseDTO() {
		List<ListEnterpriseResponseDTO> response = enterpriseService.listEnterprise();
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{idEnterprise}")
	public ResponseEntity<DetailsEnterpriseResponseDTO> enterpriseDetails(@PathVariable UUID idEnterprise) {
		DetailsEnterpriseResponseDTO response = enterpriseService.detailsEnterprise(idEnterprise);
		
		return ResponseEntity.ok(response);
		
	}
	
	@DeleteMapping("/{idEnterprise}")
	public ResponseEntity<Void> deleteEnterprise(@PathVariable UUID idEnterprise) {
		enterpriseService.deleteEnterprise(idEnterprise);
		
		return ResponseEntity.noContent().build();
	}

}
