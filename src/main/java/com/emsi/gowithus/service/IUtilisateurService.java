package com.emsi.gowithus.service;

import com.emsi.gowithus.domain.RoleVo;
import com.emsi.gowithus.domain.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.emsi.gowithus.model.Annonce;
import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Role;

import java.util.List;


public interface IUtilisateurService extends UserDetailsService {
	AppUser saveUser(AppUser u);
	Role saveRole(Role role);
	void addRoleToUser(String username,String roleName);
<<<<<<< HEAD
	List<AppUser> getAllApprouved();
	void sendMail(List<String> usersEmail,String objet,String content);
=======
>>>>>>> master
}
