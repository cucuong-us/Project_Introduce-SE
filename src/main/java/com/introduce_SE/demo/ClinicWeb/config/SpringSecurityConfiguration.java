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
		http.csrf(csrf -> csrf.disable()) // Vô hiệu hóa CSRF (nếu cần)
				.authorizeHttpRequests(auth -> auth.requestMatchers("/doLogin").permitAll() // Cho phép
																											// truy cập
																											// không cần
																											// login
						.anyRequest().authenticated() // Các request khác cần login
				).formLogin(form -> form//.loginPage("/login") // URL trang login tùy chỉnh
						.loginProcessingUrl("/doLogin") // URL xử lý login
						.defaultSuccessUrl("/home") // URL chuyển hướng sau khi login thành công
						.failureUrl("/login?error=true") // URL khi login thất bại
						.permitAll())
				.logout(logout -> logout.logoutUrl("/logout") // URL logout
						.logoutSuccessUrl("/login?logout=true") // URL khi logout thành công
						.permitAll());

		return http.build();
	}
}
