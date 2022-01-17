package com.emsi.gowithus.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emsi.gowithus.model.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<AppUser, Integer>{
	AppUser findByUsername(String username);
}
