package com.example.SecurityApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.SecurityApp.service.MyUserDetailService;

@SpringBootApplication
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityAppApplication {
	
	@Autowired
	MyUserDetailService myUserDetailService;

	public static void main(String[] args) {
		SpringApplication.run(SecurityAppApplication.class, args);
	}
	
	@Bean
	public SecurityFilterChain webSecurityFilter(HttpSecurity http) {
		return http
		.csrf(csrf->csrf.disable()) //for rest api
		.authorizeHttpRequests(auth-> auth.anyRequest().authenticated())
		.authenticationProvider(getAuthenticationProvider())
		.httpBasic(Customizer.withDefaults())
		.build();
	}
	
	
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider dao= new DaoAuthenticationProvider(myUserDetailService);
		dao.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return dao;
	}
}
