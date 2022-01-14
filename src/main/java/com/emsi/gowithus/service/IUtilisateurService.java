package com.emsi.gowithus.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.emsi.gowithus.model.Utilisateur;

public interface IUtilisateurService extends UserDetailsService {
	public void saveUser(Utilisateur u);
	
}
