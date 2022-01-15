package com.emsi.gowithus.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.emsi.gowithus.model.Annonce;
import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Role;


public interface IUtilisateurService extends UserDetailsService {
	public void saveUser(AppUser u);
	Role saveRole(Role role);
	void addRoleToUser(String username,String roleName);
}
