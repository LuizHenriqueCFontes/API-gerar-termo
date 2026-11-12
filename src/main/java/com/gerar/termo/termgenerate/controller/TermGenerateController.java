package com.gerar.termo.termgenerate.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerar.termo.termgenerate.dto.GenerateTermRequestDTO;
import com.gerar.termo.termgenerate.service.TermGenerateService;

@RestController
@RequestMapping("/api/terms")
public class TermGenerateController {
	
	private final TermGenerateService termGenerateService;
	
	public TermGenerateController(TermGenerateService termGenerateService) {
		this.termGenerateService = termGenerateService;
	}
	
	public ResponseEntity<byte[]> generateTerm(@RequestBody GenerateTermRequestDTO request) {
		
		byte[] document = termGenerateService.generateTerm(request);
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, 
				"attachament; filename=termo_responsabilidade.docx").
				contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.wordprocessingml.document"))
				.body(document);
	}

}
