package com.example.SecurityApp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredController {
	
	@GetMapping("/publicEndPoint")
	public String forPublic() {
		return "this is the open end point for public";
	}
	
	
	@GetMapping("/securedUserEndPoint")
	@PreAuthorize("hasRole('ADMIN')")
	public String forUsers() {
		return "this is the secured end point only for user";
	}
	
	@GetMapping("/securedAdminEndPoint")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public String forAdmins() {
		return "this is the secured end point only for admin";
	}

}
