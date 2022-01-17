package com.emsi.gowithus.service;

import com.emsi.gowithus.domain.RoleVo;
import com.emsi.gowithus.domain.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.emsi.gowithus.model.Annonce;
import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Role;


public interface IUtilisateurService extends UserDetailsService {
	void saveUser(AppUser u);
	void saveRole(Role role);
	void addRoleToUser(String username,String roleName);
}
