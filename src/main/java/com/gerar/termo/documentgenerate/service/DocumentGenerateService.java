package com.gerar.termo.documentgenerate.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.deepoove.poi.XWPFTemplate;
import com.gerar.termo.documentgenerate.exception.DocumentGenerationException;
import com.gerar.termo.termgenerate.dto.TermDocumentDataDTO;

@Service
public class DocumentGenerateService {
	
	private static final String TEMPLATE_PATH = "templates/termo_responsabilidade.docx";
	
	public byte[] generateDocument(TermDocumentDataDTO data) {
		
		ClassPathResource resource = new ClassPathResource(TEMPLATE_PATH);
		
		try(InputStream inputStream = resource.getInputStream(); 
			XWPFTemplate template = XWPFTemplate.compile(inputStream);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
			
			template.render(data);
			template.write(outputStream);
			
			return outputStream.toByteArray();
			
		} catch(IOException e) {
			throw new DocumentGenerationException("Erro ao gerar documento DOCX", e);
			
		}
		
	}

}
