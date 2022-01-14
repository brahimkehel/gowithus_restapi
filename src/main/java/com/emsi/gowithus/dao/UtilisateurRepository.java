package com.emsi.gowithus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emsi.gowithus.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{
	Utilisateur findbyUsername(String username);
}
