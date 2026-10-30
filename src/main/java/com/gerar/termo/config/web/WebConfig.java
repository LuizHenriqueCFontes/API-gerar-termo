package com.gerar.termo.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Bean
	PageableHandlerMethodArgumentResolverCustomizer customizer() {
		return resolver -> resolver.setMaxPageSize(20);	
	}
}
