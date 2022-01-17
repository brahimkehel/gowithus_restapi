package com.emsi.gowithus.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.emsi.gowithus.model.Annonce;
import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Role;

import java.util.List;


public interface IUtilisateurService extends UserDetailsService {
	AppUser saveUser(AppUser u);
	Role saveRole(Role role);
	void addRoleToUser(String username,String roleName);

}
