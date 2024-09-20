package com.introduce_SE.demo.ClinicWeb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.introduce_SE.demo.ClinicWeb.service.impl.CustomUserDetailsService;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/home").permitAll()// Cho phép truy cập vào /home mà không cần đăng nhập
            .anyRequest().authenticated()          // Mọi yêu cầu khác yêu cầu phải đăng nhập
        )
        .formLogin(login -> login 	// Cấu hình trang đăng nhập tùy chỉnh
            .permitAll()
        )
        .logout(logout -> logout
            .permitAll()
        );
    return http.build();
    }
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
            .requestMatchers("/resources/**", "/static/**", "/WEB-INF/views/**");  // Ignore static resources and JSPs
    }
}



