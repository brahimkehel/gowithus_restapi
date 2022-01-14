package com.emsi.gowithus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsi.gowithus.dao.UtilisateurRepository;
import com.emsi.gowithus.model.Conducteur;
import com.emsi.gowithus.model.Utilisateur;

@RestController
@RequestMapping("/Utilisateurs")
public class UtilisateurController {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@PostMapping("/save")
	public ResponseEntity<Utilisateur> saveUser(@RequestBody Conducteur conducteur){
		return ResponseEntity.ok().body(utilisateurRepository.save(conducteur));
	}
}
