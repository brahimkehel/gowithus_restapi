package com.emsi.gowithus.service;

import com.emsi.gowithus.domain.RoleVo;
import com.emsi.gowithus.domain.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.emsi.gowithus.model.Annonce;
import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Role;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;


public interface IUtilisateurService extends UserDetailsService {
	AppUser saveUser(AppUser u);
	Role saveRole(Role role);
	void addRoleToUser(String username,String roleName);
	void sendMail(List<String> usersEmail,String objet,String content);
	List<AppUser> getAllApprouved();
	void deleteUser(Long id);
}
