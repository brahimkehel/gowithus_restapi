package com.emsi.gowithus.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.emsi.gowithus.model.AppUser;


public interface IUtilisateurService extends UserDetailsService {
	public void saveUser(AppUser u);
	
}
