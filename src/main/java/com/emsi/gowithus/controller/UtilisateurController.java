package com.emsi.gowithus.controller;

import com.emsi.gowithus.model.Passager;
import com.emsi.gowithus.service.IUtilisateurService;
import com.emsi.gowithus.service.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emsi.gowithus.dao.UtilisateurRepository;
import com.emsi.gowithus.model.AppUser;
import com.emsi.gowithus.model.Conducteur;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Utilisateurs")
public class UtilisateurController {

	@Autowired
	private IUtilisateurService utilisateurService;
	
	@PostMapping("/saveConducteur")
	public ResponseEntity<AppUser> saveConducteur(@RequestBody Conducteur conducteur){
		System.out.println("=======================================");
		System.out.println("Conducteur " +conducteur);
		System.out.println("=======================================");
		AppUser user=utilisateurService.saveUser(conducteur);
		utilisateurService.addRoleToUser(conducteur.getUsername(), "ROLE_Conducteur");
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/savePassager")
	public ResponseEntity<AppUser> savePassager(@RequestBody Passager passager){
		AppUser user=utilisateurService.saveUser(passager);
		utilisateurService.addRoleToUser(passager.getUsername(), "ROLE_Passager");
		return ResponseEntity.ok().body(user);
	}
}
