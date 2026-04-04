package com.example.SecurityApp.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.SecurityApp.users.Myusers;

public class MyUserDetail implements UserDetails{
	
	Myusers user;
	
	public MyUserDetail(Myusers user) {
		this.user=user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(user.getRole().split(","))
		        .map(obj -> new SimpleGrantedAuthority(obj))
		        .collect(Collectors.toList());
		
		// TODO Auto-generated method stub
	
	}

	@Override
	public @Nullable String getPassword() {
		
		return user.getPassword();
		
		// TODO Auto-generated method stub
	}

	@Override
	public String getUsername() {
		return user.getUsername();
		// TODO Auto-generated method stub
		
	}

}
