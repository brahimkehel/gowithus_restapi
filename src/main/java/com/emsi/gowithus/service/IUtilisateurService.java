package com.emsi.gowithus.service;

import com.emsi.gowithus.model.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUtilisateurService extends UserDetailsService {
	public void saveUser(AppUser u);
	
}
