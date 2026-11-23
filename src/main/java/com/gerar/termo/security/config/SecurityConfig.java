package com.gerar.termo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http, CorsConfigurationSource corsConfigurationSource) throws Exception {
		http.cors(cors -> cors.configurationSource(corsConfigurationSource))
		.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST, "/api/enterprise").permitAll()
										.requestMatchers(HttpMethod.PATCH, "/api/enterprise/*").permitAll()
										.requestMatchers(HttpMethod.GET, "/api/enterprise").permitAll()
										.requestMatchers(HttpMethod.GET, "/api/enterprise/*").permitAll()
										.requestMatchers(HttpMethod.DELETE, "/api/enterprise/*").permitAll()
										
										.requestMatchers(HttpMethod.POST, "/api/terms/generate").permitAll()
										.anyRequest().authenticated());
		
		return http.build();
		
	}

}
