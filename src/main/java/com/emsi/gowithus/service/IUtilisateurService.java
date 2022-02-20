package com.emsi.gowithus.service;

import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Role;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface IUtilisateurService extends UserDetailsService {
	AppUser saveUser(AppUser u, MultipartFile pdp,MultipartFile cin,MultipartFile crtGrise) throws IOException;
	Role saveRole(Role role);
	void addRoleToUser(String username,String roleName);
	void sendMail(List<String> usersEmail,String objet,String content);
	List<AppUser> getAllApprouved();
	void deleteUser(Long id);
}
