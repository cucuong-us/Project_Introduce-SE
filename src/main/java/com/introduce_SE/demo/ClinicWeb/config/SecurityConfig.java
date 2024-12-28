package com.introduce_SE.demo.ClinicWeb.config;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
	
	private final String[]  PUBLIC_ENDPOINTS = {"/api/token", "/api/introspect","swagger-ui/**"};
	
	@Value("${jwt.signerKey}")
	private String signerKey;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    	httpSecurity.authorizeHttpRequests(request ->
    			request.requestMatchers(PUBLIC_ENDPOINTS).permitAll()
    			.anyRequest().authenticated()
    	);
    	
    	httpSecurity.oauth2ResourceServer(oauth2 -> 
    			oauth2.jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder()))
    	);
    	
    	httpSecurity.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());
    	
    	
    	return httpSecurity.build();
    }
    
    @Bean 
    JwtDecoder jwtDecoder() {
    	SecretKeySpec secretKeySpec = new SecretKeySpec(signerKey.getBytes(), "HS512");
    	return NimbusJwtDecoder.withSecretKey(secretKeySpec)
    			.macAlgorithm(MacAlgorithm.HS512)
    			.build();
    }

}
